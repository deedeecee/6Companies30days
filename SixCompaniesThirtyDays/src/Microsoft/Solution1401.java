package Microsoft;

public class Solution1401 {
    static boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int closestCoordinateX = helper(xCenter, x1, x2);
        int closestCoordinateY = helper(yCenter, y1, y2);

        int x = xCenter - closestCoordinateX;
        int y = yCenter - closestCoordinateY;

        return ((x * x) + (y * y)) <= (radius * radius);
    }

    private static int helper(int value, int min, int max) {
        return Math.max(min, Math.min(value, max));
    }

    public static void main(String[] args) {
        int radius = 1;
        int xCenter = 1;
        int yCenter = 1;
        int x1 = 1;
        int y1 = -3;
        int x2 = 2;
        int y2 = -1;

        System.out.println(checkOverlap(radius, xCenter, yCenter, x1, y1, x2, y2));
    }
}
