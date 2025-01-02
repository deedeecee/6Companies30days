package Microsoft;

import java.util.Arrays;

public class Solution354 {
    static int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        int[] lisArray = new int[envelopes.length + 1];     // longest increasing subsequence array
        Arrays.fill(lisArray, Integer.MAX_VALUE);
        lisArray[0] = Integer.MIN_VALUE;

        int maxNestedCount = 0;

        for (int[] envelope : envelopes) {
            int currentHeight = envelope[1];
            int insertIndex = findInsertPosition(lisArray, currentHeight);

            maxNestedCount = Math.max(maxNestedCount, insertIndex);

            if (lisArray[insertIndex] >= currentHeight) {
                lisArray[insertIndex] = currentHeight;
            }
        }

        return maxNestedCount;
    }

    static int findInsertPosition(int[] lisArray, int value) {
        int start = 0;
        int end = lisArray.length - 1;
        int currentPosition = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (lisArray[mid] < value) {
                currentPosition = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return currentPosition + 1;
    }

    public static void main(String[] args) {
        int[][] envelopes =
                {
                        {5, 4},
                        {6, 4},
                        {6, 7},
                        {2, 3}
                };

        System.out.println(maxEnvelopes(envelopes));
    }
}
