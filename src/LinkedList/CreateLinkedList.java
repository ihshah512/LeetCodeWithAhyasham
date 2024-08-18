package LinkedList;
import java.util.*;

public class CreateLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val=val;
            next = null;
        }
    }
    ListNode head;
            public void traverse(){

                ListNode current = head;
                while(current != null){
                    System.out.println(current.val);
                    current = current.next;
                }
            }

public static void main(String[] args){

        CreateLinkedList ll = new CreateLinkedList();
          //      LinkedList ll = new LinkedList();

        ll.head = new ListNode(1);//good
        ListNode two = new ListNode(10);
        ListNode three = new ListNode(100);
        ll.head.next = two;
        two.next = three;
        ll.traverse();



}


}
