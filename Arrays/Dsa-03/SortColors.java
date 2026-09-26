public class SortColors {

    public static void sortColors(int[] nums) {

        // Write your solution here

        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        while(mid <= right){
            if(nums[mid] == 0){
                int temp = nums[mid];
                nums[mid] = nums[left];
                nums[left] = temp;
                mid++;
                left++;
            }else if(nums[mid] == 1){
                mid++;
            }else{
                int temp = nums[right];
                nums[right] = nums[mid];
                nums[mid] = temp;
                right--;
            }
        }

    }

    public static void main(String[] args) {

        int[] nums = {2, 0, 2, 1, 1, 0};

        sortColors(nums);

        System.out.print("Sorted Colors: ");

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}