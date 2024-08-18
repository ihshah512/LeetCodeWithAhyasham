package LinkedList;
import java.util.*;

public class MIddleNode {

    public static class ListNode{

        int val;
        ListNode next;
       // ListNode head;
        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public static boolean isCyclic(ListNode head)
    {

        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head; //this is the key
        //boolean isCycle = false;
        while(fast !=null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
               return true;
            }
        }
        return false;
    }
   /*public static int getMiddle(ListNode head) {
       ListNode slow = head;
       ListNode fast = head;
       while (fast != null && fast.next != null) {
           slow = slow.next;
           fast = fast.next.next;
       }

       return slow.val;
   }

    */
    //public static boolean isCycle(ListNode head){
    public static void main(String[] args){
       // ListNode head;
        ListNode one = new ListNode(1000);
        ListNode two = new ListNode(2000);
        ListNode three = new ListNode(3000);
        ListNode four = new ListNode(4000);
        ListNode five = new ListNode(5000);
       // head =one;

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next=one;
       // System.out.println(getMiddle(head));
        System.out.println(isCyclic(one));
        /*ListNode dum = head;
        boolean isCycle = false;
        ListNode slowPtr = head.next;
        ListNode fastPtr = head.next.next;
*/
      //  System.out.println(isCycle);

    }
}
