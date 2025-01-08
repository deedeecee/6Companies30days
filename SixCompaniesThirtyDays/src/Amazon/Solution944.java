package Amazon;

import java.util.LinkedList;
import java.util.Queue;

public class Solution944 {
    static int orangesRotting(int[][] grid) {
        final int[][] directions =
                {
                        {-1, 0},
                        {1, 0},
                        {0, -1},
                        {0, 1}
                };

        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int countOfFreshOranges = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                }

                if (grid[i][j] == 1) {
                    countOfFreshOranges++;
                }
            }
        }

        if (countOfFreshOranges == 0) {
            return 0;
        } else if (queue.isEmpty()) {
            return -1;
        }

        int minutes = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();

                assert current != null;
                int currentX = current[0];
                int currentY = current[1];

                for (int[] direction : directions) {
                    int nextX = currentX + direction[0];
                    int nextY = currentY + direction[1];

                    if (isValid(nextX, nextY, m, n) && (grid[nextX][nextY] == 1)) {
                        grid[nextX][nextY] = 2;
                        countOfFreshOranges--;
                        queue.offer(new int[] {nextX, nextY});
                    }
                }
            }

            minutes++;
        }

        return (countOfFreshOranges == 0) ? minutes : -1;
    }

    private static boolean isValid(int x, int y, int m, int n) {
        return (x >= 0) && (x < m) && (y >= 0) && (y < n);
    }

    public static void main(String[] args) {
        int[][] grid =
                {
                        {2, 1, 1},
                        {1, 1, 0},
                        {0, 1, 1}
                };

        System.out.println(orangesRotting(grid));
    }
}
