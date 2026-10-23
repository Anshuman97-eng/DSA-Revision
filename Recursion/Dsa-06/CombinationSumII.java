
import java.util.*;

public class CombinationSumII {

    public static void backTrack(
            int[] candidates,
            int idx,
            int target,
            List<List<Integer>> result,
            List<Integer> temp) {

        // Write your backtracking logic here

        if(target < 0){
            return;
        }

        if(target == 0){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i = idx ; i < candidates.length ; i++){
            if(i>idx && candidates[i] == candidates[i-1]){
                continue;
            }

            temp.add(candidates[i]);
            backTrack(candidates, i+1, target - candidates[i], result, temp);
            temp.remove(temp.size() - 1);
        }

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);

        backTrack(candidates, 0, target, result, temp);

        return result;
    }

    public static void main(String[] args) {
        CombinationSumII solution = new CombinationSumII();

        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        List<List<Integer>> result = solution.combinationSum2(candidates, target);

        System.out.println(result);
        // Expected: [[1, 1, 6], [1, 2, 5], [1, 7], [2, 6]]
    }
}
