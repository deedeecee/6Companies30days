package Microsoft;

import java.util.*;

public class Solution2976 {
    static final int INF = Integer.MAX_VALUE / 2;

    static long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = source.length();

        int[][] shortestPaths = constructGraphAndComputeShortestPaths(original, changed, cost);

        long totalCost = 0;

        for (int i = 0; i < n; i++) {
            char start = source.charAt(i);
            char end = target.charAt(i);

            if (start != end) {
                int minCost = shortestPaths[start][end];
                if (minCost == INF) {
                    return -1;
                }
                totalCost += minCost;
            }
        }

        return totalCost;
    }

    public static int[][] constructGraphAndComputeShortestPaths(char[] original, char[] changed, int[] cost) {
        int size = 128;
        int[][] graph = new int[size][size];

        for (int i = 0; i < size; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }

        for (int i = 0; i < original.length; i++) {
            char from = original[i];
            char to = changed[i];
            graph[from][to] = Math.min(graph[from][to], cost[i]);
        }

        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (graph[i][k] < INF && graph[k][j] < INF) {
                        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                    }
                }
            }
        }

        return graph;
    }

    public static void main(String[] args) {
        String source = "abcd";
        String target = "abce";
        char[] original = {'a'};
        char[] changed = {'e'};
        int[] cost = {10000};

        System.out.println(minimumCost(source, target, original, changed, cost));
    }
}
