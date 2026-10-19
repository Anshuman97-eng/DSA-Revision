
public class SplitArrayLargestSum {
    public static boolean isValid(int[] nums,int mid ,int k){
        int count = 1;
        int sum = 0;

        for(int n : nums){
            if(sum + n >= mid){
                sum = 0;
                count = count + 1;
            }
            sum += n;
        }
        return count <= k;
    }

    public int splitArray(int[] nums, int k) {
        // Write your solution here
        int low =0;
        int high = 0;

        for(int n : nums){
            low = Math.max(low,n);
            high += n;
        }

        while (low <= high) {
            int mid = low + (high - low)/2;

            if(isValid(nums,mid,k)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        SplitArrayLargestSum solution = new SplitArrayLargestSum();

        int[] nums = {7, 2, 5, 10, 8};
        int k = 2;

        int result = solution.splitArray(nums, k);

        System.out.println(result); // Expected: 18
    }
}
