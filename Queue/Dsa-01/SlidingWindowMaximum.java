
import java.util.*;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {

        // Write your logic here
        Deque<Integer> dequeue = new ArrayDeque<>();
        int count = 0;
        int n = nums.length;

        int[] arr = new int[n - k + 1];

        for(int i=0 ; i<nums.length ; i++){
            while (!dequeue.isEmpty() && dequeue.peek() < i-k ) {
                dequeue.pollFirst();
            }

            while(!dequeue.isEmpty() && nums[dequeue.peek()]  < nums[i]){
                dequeue.pollLast();
            }

            dequeue.addLast(i);
            if(i >=  k-1){
                arr[count] = nums[dequeue.peekFirst()];
                count++;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum solution = new SlidingWindowMaximum();

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] result = solution.maxSlidingWindow(nums, k);

        System.out.println(Arrays.toString(result));
        // Expected output: [3, 3, 5, 5, 6, 7]
    }
}
