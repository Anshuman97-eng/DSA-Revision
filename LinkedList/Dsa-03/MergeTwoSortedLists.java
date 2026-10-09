
public class MergeTwoSortedLists {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // Write your recursive logic here

        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }


        if(list1.val < list2.val){
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }else{
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {

        MergeTwoSortedLists solution = new MergeTwoSortedLists();

        // List 1: 1 -> 3 -> 5
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);

        // List 2: 2 -> 4 -> 6
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);

        ListNode result = solution.mergeTwoLists(list1, list2);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
