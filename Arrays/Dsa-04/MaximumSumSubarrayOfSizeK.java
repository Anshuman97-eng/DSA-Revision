public class MaximumSumSubarrayOfSizeK {

    public static int maxSumSubarray(int[] nums, int k) {

        // Write your solution here
        int maxSum = 0;
        int sum = 0;
        int left = 0;

        for(int i=0 ;i<nums.length ; i++){
            if(i > 2){
                sum -= nums[left];
                left++;
            }
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        
        return maxSum;
    }

    public static void main(String[] args) {

        int[] nums = {2, 1, 5, 1, 3, 2};
        int k = 3;

        int result = maxSumSubarray(nums, k);

        System.out.println("Maximum Sum: " + result);
    }
}