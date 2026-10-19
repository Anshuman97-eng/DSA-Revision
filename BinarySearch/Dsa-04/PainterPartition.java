
public class PainterPartition {

    public static boolean isValid(int[] boards,int mid, int k){
        int count = 1;
        int max = 0;

        for(int i : boards){
            if(max + i > mid){
                max = 0;
                count++;
            }

            max += i;
        }

        return count <= k;
    }

    public int findMinTime(int[] boards, int k) {
        // Write your solution here
        int low = 0;
        int high = 0;

        for(int i : boards){
            low = Math.max(low,i);
            high += i;
        }

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(isValid(boards,mid,k)){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        PainterPartition solution = new PainterPartition();

        int[] boards = {10, 20, 30, 40};
        int k = 2;

        int result = solution.findMinTime(boards, k);

        System.out.println(result); // Expected: 60
    }
}
