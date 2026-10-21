
import java.util.*;

public class PermutationsII {

    public static void backTrack(int[] nums,List<List<Integer>> result,List<Integer> temp,boolean[] mark){
        if(nums.length == temp.size()){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0 ; i<nums.length ; i++){
            if(mark[i]){
                continue;
            }

            if(i > 0 && nums[i] == nums[i-1] && !mark[i-1]){
                continue;
            }

            mark[i] = true;
            temp.add(nums[i]);

            backTrack(nums, result, temp, mark);

            mark[i] = false;
            temp.remove(temp.size() - 1);
        }


    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        // Write your solution here
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] mark = new boolean[nums.length];
        Arrays.sort(nums);

        backTrack(nums,result,temp,mark);

        return result;
    }

    public static void main(String[] args) {
        PermutationsII solution = new PermutationsII();

        int[] nums = {1, 1, 2};

        List<List<Integer>> result = solution.permuteUnique(nums);

        System.out.println(result);
        // Expected: [[1, 1, 2], [1, 2, 1], [2, 1, 1]]
    }
}
