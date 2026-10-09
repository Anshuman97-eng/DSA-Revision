
import java.util.*;

public class MergeKSortedListsPQ {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        // Write your PriorityQueue logic here

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);

        for(ListNode head : lists){
            if(head != null){
                pq.offer(head);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(!pq.isEmpty()){
            ListNode curr = pq.poll();
            tail.next = curr;
            tail = tail.next;

            if(curr.next != null){
                pq.offer(curr.next);
            }
        }



        return dummy.next;
    }

    public static void main(String[] args) {

        MergeKSortedListsPQ solution = new MergeKSortedListsPQ();

        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);

        ListNode[] lists = {list1, list2, list3};

        ListNode result = solution.mergeKLists(lists);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
