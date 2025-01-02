package Microsoft;

public class Solution1248 {
    static int numberOfSubarrays(int[] nums, int k) {
        int answer = 0;
        int count = 0;

        for (int i = 0, j = 0; j < nums.length; j++) {
            if ((nums[j] % 2) != 0) {
                k--;
                count = 0;
            }

            while (k == 0) {
                count++;

                if ((nums[i++] % 2) != 0) {
                    k++;
                }
            }

            answer += count;
        }

        return answer;
    }


    public static void main(String[] args) {
        int[] nums = {1,1,2,1,1};
        int k = 3;

        System.out.println(numberOfSubarrays(nums, k));
    }
}
