package Microsoft;

import java.util.Arrays;

public class Solution661 {
    static int rows;
    static int cols;
    static final int[][] directions =
            {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1}, {0, 1},
                {1, -1}, {1, 0}, {1, 1}
            };

    static int[][] imageSmoother(int[][] img) {
        rows = img.length;
        cols = img[0].length;
        int[][] answer = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                answer[row][col] = calculateAverage(img, row, col);
            }
        }

        return answer;
    }

    private static int calculateAverage(int[][] img, int row, int col) {
        int sum = img[row][col];
        int count = 1;

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if ((newRow >= 0) && (newRow < rows) && (newCol >= 0) && (newCol < cols)) {
                sum += img[newRow][newCol];
                count++;
            }
        }

        return sum / count;
    }

    public static void main(String[] args) {
        int[][] img =
                {
                        {100,200,100},
                        {200,50,200},
                        {100,200,100}
                };

        for (int[] arr : imageSmoother(img)) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
