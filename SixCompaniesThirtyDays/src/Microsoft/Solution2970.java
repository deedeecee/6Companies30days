package Microsoft;

public class Solution2970 {
    static int incremovableSubarrayCount(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (isIncremovable(nums, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean isIncremovable(int[] nums, int start, int end) {
        int previous = 0;

        for (int i = 0; i < nums.length; i++) {
            if ((i >= start) && (i <= end)) {
                continue;
            }

            if (nums[i] <= previous) {
                return false;
            }

            previous = nums[i];
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums = {8,7,6,6};
        System.out.println(incremovableSubarrayCount(nums));
    }
}
