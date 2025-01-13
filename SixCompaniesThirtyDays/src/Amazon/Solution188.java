package Amazon;

public class Solution188 {
    static int maxProfit(int k, int[] prices) {
        if (k >= (prices.length) / 2) {
            int max = 0;

            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    max += prices[i] - prices[i - 1];
                }
            }

            return max;
        }

        int[][] memo = new int[k + 1][prices.length];

        for (int i = 1; i <= k; i++) {
            int maxDiff = -prices[0];

            for (int j = 1; j < prices.length; j++) {
                memo[i][j] = Math.max(memo[i][j - 1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, memo[i - 1][j] - prices[j]);
            }
        }

        return memo[k][prices.length - 1];
    }

    public static void main(String[] args) {
        int k = 2;
        int[] prices = {3,2,6,5,0,3};

        System.out.println(maxProfit(k, prices));
    }
}
