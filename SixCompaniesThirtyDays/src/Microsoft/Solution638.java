package Microsoft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution638 {
    private static Map<String, Integer> memo;

    public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        memo = new HashMap<>();
        return dfs(price, special, needs);
    }

    private static int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        String needsKey = needs.toString();

        if (memo.containsKey(needsKey)) {
            return memo.get(needsKey);
        }

        int result = directPurchase(price, needs);

        for (List<Integer> offer : special) {
            List<Integer> newNeeds = applyOffer(needs, offer);

            if (newNeeds != null) {
                result = Math.min(result, offer.get(offer.size() - 1) + dfs(price, special, newNeeds));
            }
        }

        memo.put(needsKey, result);
        return result;
    }

    private static int directPurchase(List<Integer> price, List<Integer> needs) {
        int cost = 0;

        for (int i = 0; i < needs.size(); i++) {
            cost += price.get(i) * needs.get(i);
        }

        return cost;
    }

    private static List<Integer> applyOffer(List<Integer> needs, List<Integer> offer) {
        List<Integer> newNeeds = new ArrayList<>(needs);

        for (int i = 0; i < needs.size(); i++) {
            newNeeds.set(i, newNeeds.get(i) - offer.get(i));

            if (newNeeds.get(i) < 0) {
                return null;
            }
        }

        return newNeeds;
    }

    public static void main(String[] args) {
        List<Integer> price = List.of(2, 5);
        List<List<Integer>> special = List.of(List.of(3, 0, 5), List.of(1, 2, 10));
        List<Integer> needs = List.of(3, 2);

        System.out.println(shoppingOffers(price, special, needs));
    }
}
