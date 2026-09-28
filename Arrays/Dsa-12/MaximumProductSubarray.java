
public class MaximumProductSubarray {

    public static int maxProduct(int[] nums) {

        // Write your solution here
        int left = 1;
        int right = 1;
        int maxLeft = 1;
        int maxRight = 1;

        for(int i=0 ; i<nums.length ; i++){ 
            left *= nums[i];
            maxLeft = Math.max(left,maxLeft);
            if(left == 0) {
                left = 1;
            }
        }

        for(int i=nums.length - 1 ; i>=0 ; i--){
            right *= nums[i];
            maxRight = Math.max(right,maxRight);
            if(right == 0) {
                right = 1;
            }
        }
        if(maxLeft > maxRight){
            return  maxLeft;
        }

        return maxRight;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, -2, 4};

        int result = maxProduct(nums);

        System.out.println("Maximum Product: " + result);
    }
}