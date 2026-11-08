import java.util.*;

public class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int k) {

        // Write your logic here
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> (b[0] * b[0] + b[1] * b[1])
                    - (a[0] * a[0] + a[1] * a[1])
        );

        for(int[] i : points){
            pq.offer(i);
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[][] result = new int[k][2];

        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }

        return result;
    }

    public static void main(String[] args) {

        KClosestPointsToOrigin solution =
                new KClosestPointsToOrigin();

        int[][] points = {
            {1, 3},
            {-2, 2},
            {5, 8},
            {0, 1}
        };

        int k = 2;

        int[][] result = solution.kClosest(points, k);

        System.out.println("K Closest Points:");

        for (int[] point : result) {
            System.out.println(Arrays.toString(point));
        }
    }
}