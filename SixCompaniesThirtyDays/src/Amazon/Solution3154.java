package Amazon;

import java.util.HashMap;
import java.util.Map;

public class Solution3154 {
    static Map<String, Integer> dp;
    static int waysToReachStair(int k) {
        dp = new HashMap<>();
        return (int) (solve(1, k, 0, 0));
    }

    private static long solve(int i, int k, int wasLastDownJump, int jump) {
        if (i > k + 1) {
            return 0;
        }

        String key = i + " " + wasLastDownJump + " " + jump;

        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        long answer = (i == k) ? 1 : 0;

        answer += solve(i + (1 << jump), k, 0, jump + 1);

        if ((i != 0) && (wasLastDownJump != 1)) {
            answer += solve(i - 1, k, 1, jump);
        }

        dp.put(key, (int) answer);
        return answer;
    }


    public static void main(String[] args) {
        int k = 10;
        System.out.println(waysToReachStair(k));
    }
}
