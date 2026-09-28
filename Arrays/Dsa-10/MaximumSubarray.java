

public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {

        // Write your solution here
        int max = nums[0];
        int maxCount = nums[0];

        for(int i=1 ; i<nums.length ; i++){
            if(maxCount < 0 ){
                maxCount = 0;
            }

            maxCount += nums[i];
            max = Math.max(max, maxCount);
        }


        return max;

    }

    public static void main(String[] args) {

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int result = maxSubArray(nums);

        System.out.println("Maximum Subarray Sum: " + result);
    }
}