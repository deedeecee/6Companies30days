package Amazon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class NutsAndBoltsGFG {
    static void matchPairs(int n, char[] nuts, char[] bolts) {
        final Map<Character, Integer> order = new HashMap<>();
        order.put('!', 1);
        order.put('#', 2);
        order.put('$', 3);
        order.put('%', 4);
        order.put('&', 5);
        order.put('*', 6);
        order.put('?', 7);
        order.put('@', 8);
        order.put('^', 9);

        Character[] nutsCharArray = new Character[n];
        Character[] boltsCharArray = new Character[n];

        for (int i = 0; i < n; i++) {
            nutsCharArray[i] = nuts[i];
            boltsCharArray[i] = bolts[i];
        }

        Arrays.sort(nutsCharArray, Comparator.comparingInt(order::get));
        Arrays.sort(boltsCharArray, Comparator.comparingInt(order::get));

        for (int i = 0; i < n; i++) {
            nuts[i] = nutsCharArray[i];
            bolts[i] = boltsCharArray[i];
        }
    }

    public static void main(String[] args) {
        int n = 5;
        char[] nuts = {'@', '%', '$', '#', '^'};
        char[] bolts = {'%', '@', '#', '$', '^'};

        matchPairs(n, nuts, bolts);

        System.out.println(Arrays.toString(nuts));
        System.out.println(Arrays.toString(bolts));
    }
}
