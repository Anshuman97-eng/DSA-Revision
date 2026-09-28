

public class MaximumCircularSubarray {

    public static int maxSubarraySumCircular(int[] nums) {

        // Write your solution here
        int maxSum = nums[0];
        int max = nums[0];
        int min = nums[0];
        int minSum = nums[0];
        int totalSum = nums[0];

        for(int i=1 ; i<nums.length ; i++){
            
            if(max < 0){
                max = 0;
            }
            max += nums[i];
            maxSum = Math.max(maxSum, max);
        }

        for(int i=1 ; i<nums.length ; i++){
            if(min > 0){
                min = 0;
            }
            min += nums[i];
            minSum = Math.min(min, minSum);
            totalSum += nums[i];
        }

        if(max < 0){
            return  max;
        }

        return Math.max(max,totalSum - min);
    }

    public static void main(String[] args) {

        int[] nums = {5, -3, 5};

        int result = maxSubarraySumCircular(nums);

        System.out.println("Maximum Circular Subarray Sum: " + result);
    }
}