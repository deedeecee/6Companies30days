package Microsoft;

import java.util.Arrays;
import java.util.Random;

public class Solution497 {
    static class Solution {
        private final int[][] rects;
        private final int[] areas;
        private int totalArea;
        private final Random random;

        public Solution(int[][] rects) {
            this.rects = rects;
            this.areas = new int[rects.length];
            this.totalArea = 0;
            this.random = new Random();

            int index = 0;
            for (int[] rectangle : rects) {
                int length = rectangle[2] - rectangle[0] + 1;
                int breadth = rectangle[3] - rectangle[1] + 1;

                totalArea += (length * breadth);
                areas[index++] = totalArea;
            }
        }

        public int[] pick() {
            int target = random.nextInt(totalArea);
            int currentRectangle = 0;

            for (int i = 0; i < areas.length; i++) {
                if (target < areas[i]) {
                    currentRectangle = i;
                    break;
                }
            }

            int x = rects[currentRectangle][0] +
                            random.nextInt(rects[currentRectangle][2] - rects[currentRectangle][0] + 1);
            int y = rects[currentRectangle][1] +
                            random.nextInt(rects[currentRectangle][3] - rects[currentRectangle][1] + 1);

            return new int[] {x, y};
        }
    }

    public static void main(String[] args) {
        int[][] rects =
                {
                        {-2, -2, 1, 1},
                        {2, 2, 4, 6}
                };

        Solution solution = new Solution(rects);

        System.out.println(Arrays.toString(solution.pick()));
        System.out.println(Arrays.toString(solution.pick()));
        System.out.println(Arrays.toString(solution.pick()));
        System.out.println(Arrays.toString(solution.pick()));
        System.out.println(Arrays.toString(solution.pick()));
    }
}
