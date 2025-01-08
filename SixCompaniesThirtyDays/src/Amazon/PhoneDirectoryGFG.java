package Amazon;

import java.util.*;

public class PhoneDirectoryGFG {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        TreeSet<String> contacts = new TreeSet<>();
    }

    private static void insert(TrieNode root, String name) {
        TrieNode current = root;

        for (char ch : name.toCharArray()) {
            current.children.putIfAbsent(ch, new TrieNode());
            current = current.children.get(ch);

            current.contacts.add(name);
        }
    }

    static ArrayList<ArrayList<String>> displayContacts(int n, String[] contact, String s) {
        TrieNode root = new TrieNode();

        for (String name : contact) {
            insert(root, name);
        }

        ArrayList<ArrayList<String>> result = new ArrayList<>();

        TrieNode current = root;
        boolean prefixNotFound = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (!prefixNotFound && current.children.containsKey(ch)) {
                current = current.children.get(ch);
                result.add(new ArrayList<>(current.contacts));
            } else {
                prefixNotFound = true;
                result.add(new ArrayList<>(List.of("0")));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 3;
        String[] contact = {"geeikistest", "geeksforgeeks", "geeksfortest"};
        String s = "geeips";

        System.out.println(displayContacts(n, contact, s));
    }
}
