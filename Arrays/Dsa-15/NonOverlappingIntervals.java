

class NonOverlappingIntervals {

    public static int eraseOverlapIntervals(int[][] intervals) {

        // Sort intervals by starting value
        int count = 0;
        int[] prev = intervals[0];


        // Write your logic here
        for(int i=1 ; i<intervals.length ; i++){
            if(prev[1] > intervals[i][0]){
                count++;
                prev[1] = Math.max(prev[1], intervals[i][1]);
            }else{
                prev[1] = intervals[i][1];
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[][] intervals = {
            {1, 3},
            {2, 4},
            {5, 7},
            {6, 8}
        };

        int result = eraseOverlapIntervals(intervals);

        System.out.println("Intervals to remove: " + result);
    }
}