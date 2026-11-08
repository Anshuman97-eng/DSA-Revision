import java.util.*;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> map.get(a) - map.get(b)
        );

        for (Map.Entry<Integer, Integer> m : map.entrySet()) {

            pq.offer(m.getKey());

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] res = new int[k];
        int i = 0;

        while (!pq.isEmpty()) {
            res[i] = pq.poll();
            i++;
        }

        return res;
    }

    public static void main(String[] args) {

        TopKFrequentElements solution = new TopKFrequentElements();

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        int[] result = solution.topKFrequent(nums, k);

        System.out.println("Top K Frequent: " + Arrays.toString(result));
    }
}