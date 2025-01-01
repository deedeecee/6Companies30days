package Microsoft;

import java.util.ArrayList;
import java.util.List;

public class Solution1823 {
    static int findTheWinner(int n, int k) {
        List<Integer> friends = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            friends.add(i);
        }

        int index = 0;

        while (friends.size() > 1) {
            int indexToRemove = (index + k - 1) % friends.size();
            friends.remove(indexToRemove);
            index = indexToRemove;
        }

        return friends.get(0);
    }

    public static void main(String[] args) {
        int n = 5;
        int k = 2;

        System.out.println(findTheWinner(n, k));
    }
}
