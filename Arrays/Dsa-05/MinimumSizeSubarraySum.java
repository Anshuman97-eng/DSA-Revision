public class MinimumSizeSubarraySum {

    public static int minSubArrayLen(int target, int[] nums) {

        // Write your solution here
        int left = 0;
        int count = 0;
        int sum = 0;

        for(int i=0 ; i< nums.length ; i++){
            sum += nums[i];

            while(sum >= target){
                count = i - left + 1;
                sum -= nums[left];
                left++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};

        int result = minSubArrayLen(target, nums);

        System.out.println("Minimum Subarray Length: " + result);
    }
}