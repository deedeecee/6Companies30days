package Microsoft;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution187 {
    static List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        StringBuilder copyOfOriginal = new StringBuilder(s);
        Set<String> allSequences = new HashSet<>();
        Set<String> result = new HashSet<>();


        for (int i = 0; i <= n - 10; i++) {
            String currentSequence = copyOfOriginal.substring(i, i + 10);

            if (allSequences.contains(currentSequence)) {
                result.add(currentSequence);
            }

            allSequences.add(currentSequence);
        }

        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";

        System.out.println(findRepeatedDnaSequences(s));
    }
}
