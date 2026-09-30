import java.util.*;

class MergeIntervals {

    public static int[][] merge(int[][] intervals) {

        // Write your logic here
        int[] prev = intervals[0];
        List<int[]> result = new ArrayList<>();

        for(int i=1 ; i<intervals.length ; i++){
            if(prev[1] >= intervals[i][0]){
                prev[1] = Math.max(prev[1],intervals[i][1]);
            }else{
                result.add(new int[]{prev[0],prev[1]});
                prev[0] = intervals[i][0];
                prev[1] = intervals[i][1];
            }
        }

        result.add(prev);

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {

        int[][] intervals = {
            {1, 3},
            {2, 6},
            {8, 10},
            {15, 18}
        };

        int[][] result = merge(intervals);

        for (int[] interval : result) {
            System.out.println(
                "[" + interval[0] + ", " + interval[1] + "]"
            );
        }
    }
}