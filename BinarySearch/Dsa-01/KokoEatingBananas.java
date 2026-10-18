public class KokoEatingBananas {

    public static boolean isEatable(int[] piles,int mid ,int h){
        int hours = 0;

        for(int pile : piles){
            hours += pile /mid;

            if(pile % mid != 0){
                hours += 1;
            }
        }
        return hours <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        // Write your logic here
        int left = 1;
        int right = 0;

        for(int p : piles){
            right = Math.max(p,right);
        }

        while(left <= right){
            int mid = left + (right - left)/2;

            if(isEatable(piles,mid,h)){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        KokoEatingBananas solution = new KokoEatingBananas();

        int[] piles = {3, 6, 7, 11};
        int h = 8;

        int result = solution.minEatingSpeed(piles, h);
        System.out.println(result); // Expected: 4
    }
}