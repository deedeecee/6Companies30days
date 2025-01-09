package Amazon;

public class Solution168 {
    static String convertToTitle(int columnNumber) {
        StringBuilder answer = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--;
            answer.insert(0, (char) ((columnNumber % 26) + 'A'));
            columnNumber /= 26;
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        int col = 28;
        System.out.println(convertToTitle(col));
    }
}
