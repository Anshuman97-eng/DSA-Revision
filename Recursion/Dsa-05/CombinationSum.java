
import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void backTrack(int[] candidates, int idx, int target,
            List<List<Integer>> result, List<Integer> list) {

        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        if (idx == candidates.length || target < 0) {
            return;
        }

        // 1. Inclusion
        list.add(candidates[idx]);
        backTrack(candidates, idx + 1, target - candidates[idx], result, list);

        // 2. Multiple inclusion
        backTrack(candidates, idx, target - candidates[idx], result, list);

        // Backtrack
        list.remove(list.size() - 1);

        // 3. Exclusion
        backTrack(candidates, idx + 1, target, result, list);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        backTrack(candidates, 0, target, result, list);
        return result;
    }

    public static void main(String[] args) {
        CombinationSum solution = new CombinationSum();

        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        System.out.println(solution.combinationSum(candidates, target));
    }
}
