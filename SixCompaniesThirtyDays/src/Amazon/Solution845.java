package Amazon;

public class Solution845 {
    static int longestMountain(int[] arr) {
        int maxLength = 0;

        for (int i = 1; i < arr.length - 1; i++) {
            if ((arr[i - 1] < arr[i]) && (arr[i] > arr[i + 1])) {
                int left = i - 1;
                int right = i + 1;

                while ((left > 0) && (arr[left - 1] < arr[left])) {
                    left--;
                }

                while ((right < arr.length - 1) && (arr[right] > arr[right + 1])) {
                    right++;
                }

                maxLength = Math.max(maxLength, right - left + 1);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,4,7,3,2,5};

        System.out.println(longestMountain(arr));
    }
}
