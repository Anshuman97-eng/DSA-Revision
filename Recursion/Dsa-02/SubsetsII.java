
import java.util.*;

public class SubsetsII {

    public static void recursion(int[] nums,int count,List<Integer> list,List<List<Integer>> result){
        if(count == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[count]);
        recursion(nums, count+1, list, result);
        list.remove(list.size() - 1);

        while(count < nums.length - 1 && nums[count] == nums[count + 1]){
            count++;
        }

        recursion(nums, count+1, list, result);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // Write your solution here
        List<List<Integer>> result = new ArrayList<>();

        recursion(nums, 0, new ArrayList<>(), result);

        return result;
    }

    public static void main(String[] args) {
        SubsetsII solution = new SubsetsII();

        int[] nums = {1, 2, 2};

        List<List<Integer>> result = solution.subsetsWithDup(nums);

        System.out.println(result);

        // Expected: [[], [1], [1, 2], [1, 2, 2], [2], [2, 2]]
    }
}
