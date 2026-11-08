import java.util.PriorityQueue;

public class KthLargestElement {

    public int findKthLargest(int[] nums, int k) {

        // Write your logic here
        //min heap ..
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int n : nums){
            pq.offer(n);
            if(pq.size() > 2){
                pq.poll();
            }
        }


        return pq.peek();
    }

    public static void main(String[] args) {

        KthLargestElement solution = new KthLargestElement();

        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        int result = solution.findKthLargest(nums, k);

        System.out.println("Kth Largest: " + result);
    }
}