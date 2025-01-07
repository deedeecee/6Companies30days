package Amazon;

import java.util.HashSet;
import java.util.Set;

public class Solution2461 {
    static long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> seen = new HashSet<>();
        long currentSum = 0;
        long maxSumTillNow = 0;
        int left = 0;
        int right = 0;

        while (right < n) {
            if (!seen.contains(nums[right])) {
                currentSum += nums[right];
                seen.add(nums[right]);

                if ((right - left + 1) == k) {
                    maxSumTillNow = Math.max(maxSumTillNow, currentSum);
                    currentSum -= nums[left];
                    seen.remove(nums[left]);
                    left++;
                }
            } else {
                while (nums[left] != nums[right]) {
                    currentSum -= nums[left];
                    seen.remove(nums[left]);
                    left++;
                }

                left++;
            }

            right++;
        }

        return maxSumTillNow;
    }

    public static void main(String[] args) {
        int[] nums = {9,9,9};
        int k = 3;

        System.out.println(maximumSubarraySum(nums, k));
    }
}
