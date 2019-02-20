import java.io.*;
import java.util.*;

//You are in charge of a display advertising program. Your ads are displayed on websites all over the internet. You have some CSV input data that counts how many times you showed an ad on each individual domain. Every line consists of a count and a domain name. It looks like this:

// counts = [ "900,google.com",
//      "60,mail.yahoo.com",
//      "10,mobile.sports.yahoo.com",
//      "40,sports.yahoo.com",
//      "300,yahoo.com",
//      "10,stackoverflow.com",
//      "2,en.wikipedia.org",
//      "1,es.wikipedia.org",
//      "1,mobile.sports"]

//Write a function that takes this input as a parameter and returns a data structure containing the number of hits that
// were recorded on each domain AND each domain under it. For example, an impression on "mail.yahoo.com" counts for
// "mail.yahoo.com", "yahoo.com", and "com". (Subdomains are added to the left of their parent domain. So "mail" and "mail.yahoo" are not valid domains.)


//Sample output (in any order):


// getTotalsByDomain(counts)
//   1320    com
//    900    google.com
//    410    yahoo.com
//     60    mail.yahoo.com
//     10    mobile.sports.yahoo.com
//     50    sports.yahoo.com
//     10    stackoverflow.com
//      3    org
//      3    wikipedia.org
//      2    en.wikipedia.org
//      1    es.wikipedia.org
//      1    mobile.sports
//      1    sports



class DomainsCount {

    // counts = [ "900,google.com",
//      "60,mail.yahoo.com",
//      "10,mobile.sports.yahoo.com",
//      "40,sports.yahoo.com",
//      "300,yahoo.com",
//      "10,stackoverflow.com",
//      "2,en.wikipedia.org",
//      "1,es.wikipedia.org",
//      "1,mobile.sports"]
//  yahoocom.com


    public static HashMap<String,Integer> getTotalsByDomain(String[] counts){
        HashMap<String,Integer> map = new HashMap<>();
        HashMap<String,Integer> finalMap = new HashMap<>();

        int countLength= counts.length;

        for( String domain : counts){
            String subDomain[] = domain.split(",");
            map.put(subDomain[1],Integer.valueOf(subDomain[0]));
        }

        for( String key : map.keySet()){

            String subDomain1[] = key.split("\\.");
            int subLength = subDomain1.length;
            //System.out.println("\n" + key + "\t" + map.get(key));
            String breakSubDomain="";
            for(int i=subLength - 1; i>=0; i--){
                breakSubDomain= subDomain1[i] + breakSubDomain;
                finalMap.put(breakSubDomain, finalMap.getOrDefault(breakSubDomain,0) + map.get(key));
                //System.out.println(breakSubDomain + "\t" + finalMap.get(breakSubDomain) );
                breakSubDomain = "." + breakSubDomain;
            }

        }



        return finalMap;
    }

    public static void main(String[] args) {
        String[] counts = {
                "900,google.com",
                "60,mail.yahoo.com",
                "10,mobile.sports.yahoo.com",
                "40,sports.yahoo.com",
                "300,yahoo.com",
                "10,stackoverflow.com",
                "2,en.wikipedia.org",
                "1,es.wikipedia.org",
                "1,mobile.sports"
        };
        System.out.println(getTotalsByDomain (counts));

    }
}

