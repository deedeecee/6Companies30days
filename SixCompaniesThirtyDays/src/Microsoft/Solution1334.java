package Microsoft;

import java.util.Arrays;

public class Solution1334 {
    static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] distanceMatrix = new int[n][n];
        
        for (int[] row : distanceMatrix) {
            Arrays.fill(row, 10001);
        }

        for (int i = 0; i < n; i++) {
            distanceMatrix[i][i] = 0;
        }

        for (int[] edge : edges) {
            int source = edge[0];
            int destination = edge[1];
            int weight = edge[2];

            distanceMatrix[source][destination] = weight;
            distanceMatrix[destination][source] = weight;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    distanceMatrix[i][j] = Math.min(distanceMatrix[i][j], distanceMatrix[i][k] + distanceMatrix[k][j]);
                }
            }
        }

        int minimumNeighbors = n;
        int answerNode = 0;

        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (distanceMatrix[i][j] <= distanceThreshold) {
                    count++;
                }
            }

            if (count <= minimumNeighbors) {
                minimumNeighbors = count;
                answerNode = i;
            }
        }

        return answerNode;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges =
                {
                        {0,1,2},
                        {0,4,8},
                        {1,2,3},
                        {1,4,2},
                        {2,3,1},
                        {3,4,1}
                };
        int distanceThreshold = 2;

        System.out.println(findTheCity(n, edges, distanceThreshold));
    }
}
