import java.util.List;


class Node {
    public int data;
    public Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class DeepCopy {


    public static Node deepCopy( Node head){
        //fill in your code
        Node dummy = new Node(-999);
        Node iterator = dummy;

        while( head != null){
            iterator.next = new Node(head.data);
            head = head.next;
            iterator = iterator.next;

        }

        return dummy.next;
    }

    public static void main(String[] args){

        Node head = new Node(0);
        Node rememberHead = head;

        for(int i=1; i<10; i++){
            head.next = new Node(i);
            head = head.next;
        }

        deepCopy(rememberHead);
    }


}
