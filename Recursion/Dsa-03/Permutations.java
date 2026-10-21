
import java.util.*;

public class Permutations {

    public void backTrack(int[] nums,List<Integer> current,List<List<Integer>> result,boolean[] mark){
        if(current.size() == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i =0; i<nums.length ; i++){
            if(mark[i]){
                continue;
            }
            
            mark[i] = true;
            current.add(nums[i]);

            backTrack(nums, current, result, mark);

            mark[i] = false;
            current.remove(current.size() - 1);

        }
    }

    public List<List<Integer>> permute(int[] nums) 
    {
        // Write your solution here
        List<List<Integer>> result = new ArrayList<>();
        boolean[] mark = new boolean[nums.length];
        backTrack(nums,new ArrayList<>(),result,mark);
        return result;
    }

    public static void main(String[] args) {
        Permutations solution = new Permutations();

        int[] nums = {1, 2, 3};

        List<List<Integer>> result = solution.permute(nums);

        System.out.println(result);
        // Expected: 6 unique permutations
    }
}
