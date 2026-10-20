
import java.util.*;

public class Subsets {

    public static void recursion(int[] nums,int i,List<Integer> list,List<List<Integer>> result){
        if(i == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[i]);
        recursion(nums, i + 1, list, result);
        list.remove(list.size() - 1);
        recursion(nums, i + 1, list, result);
    }

    public List<List<Integer>> subsets(int[] nums) {
        // Write your solution here
        List<List<Integer>> list = new ArrayList<>();
        recursion(nums,0,new ArrayList<>(),list);

        return list;
    }

    public static void main(String[] args) {
        Subsets solution = new Subsets();

        int[] nums = {1, 2};

        List<List<Integer>> result = solution.subsets(nums);

        System.out.println(result);
        // Expected: [[], [1], [2], [1, 2]]
    }
}
