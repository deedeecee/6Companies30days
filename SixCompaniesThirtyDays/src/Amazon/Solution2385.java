package Amazon;

import java.util.*;

public class Solution2385 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }

        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
        }
    }

    static int amountOfTime(TreeNode root, int start) {
        Map<Integer, List<Integer>> graph = convertToGraph(root);
        Map<Integer, Integer> distancesFromNodes = calculateDistances(graph, start);

        int max = -1;

        for (Map.Entry<Integer, Integer> entry : distancesFromNodes.entrySet()) {
            max = Math.max(max, entry.getValue());
        }

        return max;
    }

    // Method to calculate distances using BFS
    public static Map<Integer, Integer> calculateDistances(Map<Integer, List<Integer>> graph, int startNode) {
        Map<Integer, Integer> distances = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        // Initialize
        queue.add(startNode);
        visited.add(startNode);
        distances.put(startNode, 0);

        // BFS Traversal
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            int currentDistance = distances.get(currentNode);

            // Process neighbors
            for (int neighbor : graph.getOrDefault(currentNode, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                    distances.put(neighbor, currentDistance + 1);
                }
            }
        }

        return distances;
    }

    public static Map<Integer, List<Integer>> convertToGraph(TreeNode root) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        buildGraph(root, graph);
        return graph;
    }

    private static void buildGraph(TreeNode node, Map<Integer, List<Integer>> graph) {
        if (node == null) return;

        // Ensure the current node is in the graph
        graph.putIfAbsent(node.val, new ArrayList<>());

        // Process the left child
        if (node.left != null) {
            graph.putIfAbsent(node.left.val, new ArrayList<>());
            graph.get(node.val).add(node.left.val); // Add edge (node -> left)
            graph.get(node.left.val).add(node.val); // Add edge (left -> node)
            buildGraph(node.left, graph);
        }

        // Process the right child
        if (node.right != null) {
            graph.putIfAbsent(node.right.val, new ArrayList<>());
            graph.get(node.val).add(node.right.val); // Add edge (node -> right)
            graph.get(node.right.val).add(node.val); // Add edge (right -> node)
            buildGraph(node.right, graph);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(5, null, new TreeNode(4, new TreeNode(9), new TreeNode(2))),
                new TreeNode(3, new TreeNode(10), new TreeNode(6)));

        int start = 3;

        System.out.println(amountOfTime(root, start));
    }
}
