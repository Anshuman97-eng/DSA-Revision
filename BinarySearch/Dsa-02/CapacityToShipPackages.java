public class CapacityToShipPackages {

    public static boolean isCapable(int[] weights, int mid, int days) {
        int capacity = 0;
        int day = 1;

        for (int w : weights) {
            if (capacity + w > mid) {
                day++;
                capacity = 0;
            }
            capacity += w;
        }

        return day <= days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;

        for (int w : weights) {
            low = Math.max(low, w);
            high += w;
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (isCapable(weights, mid, days)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        CapacityToShipPackages solution = new CapacityToShipPackages();

        int[] weights = {1, 2, 3, 1, 1};
        int days = 4;

        System.out.println(solution.shipWithinDays(weights, days));
        // Output: 3
    }
}