package Microsoft;

import java.util.HashMap;
import java.util.Map;

public class Solution2002 {
    static int maxProduct(String s) {
        int n = s.length();
        Map<Integer, Integer> palindromeBitmaskLengthMap = new HashMap<>();

        for (int mask = 1; mask < (1 << n); mask++) {
            StringBuilder subsequence = new StringBuilder();

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) > 0) {
                    subsequence.append(s.charAt(i));
                }
            }

            if (isPalindrome(subsequence)) {
                palindromeBitmaskLengthMap.put(mask, subsequence.length());
            }
        }

        int answer = 0;

        for (Integer mask1 : palindromeBitmaskLengthMap.keySet()) {
            for (Integer mask2 : palindromeBitmaskLengthMap.keySet()) {
                if ((mask1 & mask2) == 0) {
                    answer = Math.max(answer,
                            palindromeBitmaskLengthMap.get(mask1) * palindromeBitmaskLengthMap.get(mask2));
                }
            }
        }

        return answer;
    }

    private static boolean isPalindrome(StringBuilder subsequence) {
        int start = 0;
        int end = subsequence.length() - 1;

        while (start < end) {
            if (subsequence.charAt(start) != subsequence.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "accbcaxxcxx";

        System.out.println(maxProduct(s));
    }
}
