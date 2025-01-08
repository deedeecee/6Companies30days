package Amazon;

public class Solution387 {
    static int firstUniqChar(String s) {
        int[] freq = new int[26];

        for (Character character : s.toCharArray()) {
            freq[character - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String s = "aabb";
        System.out.println(firstUniqChar(s));
    }
}
