

public class MergeKSortedLists {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode mergeList(ListNode list1 , ListNode list2){
        if(list1 == null){
            return list2;
        }

        if(list2 == null){
            return list1;
        }

        if(list1.val <= list2.val){
            list1.next = mergeList(list1.next, list2);
            return list1;
        }else{
            list2.next = mergeList(list1, list2.next);
            return list2;
        }
    }   

    public ListNode mergeKLists(ListNode[] lists,int start,int end) {

        // Write your recursive / divide-and-conquer logic here
        if(start == end){
            return lists[start];
        }

        int mid = start + (end - start)/2;

        ListNode l1 = mergeKLists(lists, start, mid);
        ListNode l2 = mergeKLists(lists, mid + 1, end);

        return mergeList(l1, l2);
    }

    public static void main(String[] args) {

        MergeKSortedLists solution = new MergeKSortedLists();

        // List 1: 1 -> 4 -> 5
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);

        // List 2: 1 -> 3 -> 4
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        // List 3: 2 -> 6
        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);

        ListNode[] lists = {list1, list2, list3};

        // Call your function
        ListNode result = solution.mergeKLists(lists,0,lists.length - 1);

        // Print merged list
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
