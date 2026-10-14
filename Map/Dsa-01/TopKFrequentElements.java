
import java.util.*;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        // Write your logic here
        Map<Integer,Integer> map = new HashMap<>();
        int[] res = new int[k];

        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());

        pq.addAll(map.entrySet());

        for(int i=0 ; i<k ; i++ ){
            res[i] = pq.poll().getValue();
        }

        return res;
    }

    public static void main(String[] args) {
        TopKFrequentElements solution = new TopKFrequentElements();

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        int[] result = solution.topKFrequent(nums, k);

        System.out.println(Arrays.toString(result));
        // Expected output: [1, 2]
    }
}
