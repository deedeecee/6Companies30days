package Amazon;

import java.util.HashSet;
import java.util.Set;

public class Solution36 {
    static boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (Character.isDigit(board[row][col])) {
                    String inRow = board[row][col] + " in row " + row;
                    String inCol = board[row][col] + " in col " + col;
                    String inGrid = board[row][col] + " in grid " + (row / 3) + ", " + (col / 3);

                    if (
                            seen.contains(inRow) ||
                                    seen.contains(inCol) ||
                                    seen.contains(inGrid)) {
                        return false;
                    } else {
                        seen.add(inRow);
                        seen.add(inCol);
                        seen.add(inGrid);
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board =
                {
                        {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                };

        System.out.println(isValidSudoku(board));
    }
}
