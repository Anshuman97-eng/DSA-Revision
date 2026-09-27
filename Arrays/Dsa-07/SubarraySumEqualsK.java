import java.util.*;

public class SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {

        int count = 0;
        int prefix = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for(int i = 0; i < nums.length; i++) {

            prefix += nums[i];

            int val = prefix - k;

            if(map.containsKey(val)) {
                count += map.get(val);
            }

            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1};
        int k = 2;

        int result = subarraySum(nums, k);

        System.out.println("Number of Subarrays: " + result);
    }
}