// Class name must be "Transaction_Bolt"
// Libraries included:
// json simple, guava, apache commons lang3, junit, jmock
import java.util.*;

class Dashboard {

    //will be passed during init
    int size;

    //tID are string and data is String
    LinkedHashMap<Integer, String> dataMap;

    //placeholder variable to store evicted value from linkedHashSet
    int optionalLastEntry;

    public Dashboard(int size) {
        this.size = size;
        this.dataMap =
                new LinkedHashMap<Integer, String>() {
                    protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest)
                    {
                        if(size() > size)
                            optionalLastEntry = eldest.getKey();
                        return size() > size;
                    }
                };;
    }

    //for a given tID, returns the data, or null if it is not present
    public String readTransaction(int tID) {
        return dataMap.getOrDefault(tID, null);
    }

    public Integer updateTransaction(int tID, String data) {

        //if key is already present, no need to eject any values; just update it and return null
        if(dataMap.containsKey(tID)){
            dataMap.put(tID, data);
            return null;
        }

        //Return optionalLastEntry, only when size overflows
        if(dataMap.size()  == size){
            dataMap.put(tID, data);
            return optionalLastEntry;
        }

        dataMap.put(tID, data);
        return null;

    }

    public void printMap() {
        System.out.println(dataMap);
    }

}

public class Transaction_Bolt {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
        Dashboard boldDashboard = new Dashboard(3);

        System.out.println(boldDashboard.readTransaction(1));
        System.out.println(boldDashboard.updateTransaction(1,"One"));
        System.out.println(boldDashboard.updateTransaction(2,"Two"));
        System.out.println(boldDashboard.readTransaction(1));
        System.out.println(boldDashboard.updateTransaction(2,"UpdatedTwo"));
        System.out.println(boldDashboard.readTransaction(2));
        System.out.println(boldDashboard.updateTransaction(3,"Three"));
        System.out.println(boldDashboard.updateTransaction(4,"Four"));
        System.out.println(boldDashboard.readTransaction(4));
        System.out.println(boldDashboard.updateTransaction(5,"Five"));

        boldDashboard.printMap();

    }
}

/*

        // Creating the linked hashmap and implementing 
        // removeEldestEntry() to MAX size 
        LinkedHashMap<Integer, String> li_hash_map =  
        new LinkedHashMap<Integer, String>() { 
            protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) 
            { 
                return size() > MAX; 
            } 
        };

*/

/* 
Old Content below(Plain Text):

# Problem:
# At bolt, we have a dashboard where merchants can view their recent transactions, similar to how Gmail shows recent emails.
# The transaction view only shows the most recent transactions. Each transaction has an ID and a data component.
# Design an Transaction Viewer that can do the following: 
# - Initializes with a view size (represented as an int) for the number of transaction to show at once. 
# - It also has two methods: read and write. 
# - A read operation takes a transaction ID (represented as a int), and if the transaction is in the viewer, 
#       returns the data (represented as a string), or null if it is not. 
# - A write operation takes an ID and data (represented as int and string, respectively) and stores it in the viewer. 
#       If the viewer would exceed the view size, the transaction that was least recently written to is ejected, and 
#       return the ejected transaction ID. Return null if no ejection happens.
#       Consider that a write operation could be writing a new transaction, or updating an existing one.
# 
# Please consider time complexity and readability of your code
 */