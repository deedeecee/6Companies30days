package Microsoft;

import java.util.Arrays;

public class Solution462 {
    static int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int median = nums[nums.length / 2];
        int moves = 0;

        for (int num : nums) {
            moves += Math.abs(num - median);
        }

        return moves;
    }

    public static void main(String[] args) {
        int[] nums = {-5, -2, 4};

        System.out.println(minMoves2(nums));
    }
}
