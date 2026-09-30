import java.util.ArrayList;
import java.util.List;

class InsertInterval {

    public static int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> resultList = new ArrayList<>();

        // Write your logic here
        for(int i=0 ; i<intervals.length ; i++){
            if(intervals[i][1] < newInterval[0]){
                resultList.add(new int[]{intervals[i][0],intervals[i][1]});
            }else if(newInterval[1] < intervals[i][0]){
                resultList.add(newInterval);

                for(int j = i ; j<intervals.length ; j++){
                    resultList.add(intervals[j]);
                }
            }else {
                intervals[i][0] = Math.max(intervals[i][0],newInterval[0]); 
                intervals[i][1] = Math.max(intervals[i][1],newInterval[1]); 
            }
        }



        return resultList.toArray(new int[resultList.size()][]);
    }

    public static void main(String[] args) {

        int[][] intervals = {
            {1, 3},
            {6, 9}
        };

        int[] newInterval = {2, 5};

        int[][] result = insert(intervals, newInterval);

        for (int[] interval : result) {
            System.out.println(
                "[" + interval[0] + ", " + interval[1] + "]"
            );
        }
    }
}