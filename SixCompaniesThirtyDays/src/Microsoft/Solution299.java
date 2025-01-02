package Microsoft;

public class Solution299 {
    static String getHint(String secret, String guess) {
        int n = secret.length();
        boolean[] isBull = new boolean[n];
        int[] frequencyOfNonBulls = new int[10];

        int countOfBulls = 0;
        for (int i = 0; i < n; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                isBull[i] = true;
                countOfBulls++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (!isBull[i]) {
                frequencyOfNonBulls[secret.charAt(i) - '0']++;
            }
        }

        int countOfCows = 0;
        for (int i = 0; i < n; i++) {
            if (!isBull[i] && (frequencyOfNonBulls[guess.charAt(i) - '0'] > 0)) {
                frequencyOfNonBulls[guess.charAt(i) - '0']--;
                countOfCows++;
            }
        }

        return countOfBulls + "A" + countOfCows + "B";
    }

    public static void main(String[] args) {
        String secret = "11023334";
        String guess = "23021341";

        System.out.println(getHint(secret, guess));
    }
}
