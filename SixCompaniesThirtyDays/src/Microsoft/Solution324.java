package Microsoft;

import java.util.Arrays;

public class Solution324 {
    static void wiggleSort(int[] nums) {
        if (nums.length == 1) {
            return;
        }

        Arrays.sort(nums);
        int[] answer = new int[nums.length];

        int i = 1;
        int j = nums.length - 1;

        while (j >= 0) {
            if (i >= nums.length) {
                i = 0;
            }

            answer[i] = nums[j];
            j--;
            i += 2;
        }

        System.arraycopy(answer, 0, nums, 0, nums.length);
    }
}
