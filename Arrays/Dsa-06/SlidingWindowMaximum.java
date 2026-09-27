import java.util.*;

public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {

        // Write your solution here
        Deque<Integer> dq = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        int count = 0;

        for(int i=0 ; i<nums.length ; i++){
            while (!dq.isEmpty() && dq.peekFirst() <= i-k) {
                dq.pollFirst();
            }

            while (!dq.isEmpty() && nums[dq.getLast()] < nums[i]) {
                dq.pollLast();
            }

            dq.addLast(i);

            if(i >= k - 1){
                result[count] = nums[dq.peekFirst()];
                count++; 
            }
        }


        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] result = maxSlidingWindow(nums, k);

        System.out.println(Arrays.toString(result));
    }
}