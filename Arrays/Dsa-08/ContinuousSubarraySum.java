import java.util.*;

public class ContinuousSubarraySum {

    public static boolean checkSubarraySum(int[] nums, int k) {

        // Write your solution here
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0, -1);
        int prefixSum = 0;

        for(int i=0 ; i<nums.length ; i++){
            prefixSum += nums[i];
            int rem = prefixSum % k;

           if(map.containsKey(rem)){
                if(i - map.get(rem) >= 2){
                    return true;
                }
           }else{
                map.put(rem,i );
            }

        }


        return false;
    }

    public static void main(String[] args) {

        int[] nums = {23, 2, 4, 6, 7};
        int k = 6;

        boolean result = checkSubarraySum(nums, k);

        System.out.println("Result: " + result);
    }
}