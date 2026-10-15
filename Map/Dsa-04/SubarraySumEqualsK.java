import java.util.*;

public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        // Write your logic here
        int prefix = 0;
        int count = 0;
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        for(int n : nums){
            prefix += n;
            sum = prefix - k;
            if(map.containsKey(sum)){
                count = count + 1;
            }
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK solution = new SubarraySumEqualsK();

        int[] nums = {1, 1, 1};
        int k = 2;

        int result = solution.subarraySum(nums, k);

        System.out.println(result);
        // Expected output: 2
    }
}