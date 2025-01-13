package Amazon;

import java.util.LinkedList;
import java.util.Queue;

public class Solution297 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static class Codec {
        public String serialize(TreeNode root) {
            if (root == null) {
                return "null";
            }

            StringBuilder result = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();

                if (node == null) {
                    result.append("null,");
                } else {
                    result.append(node.val).append(",");

                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }

            result.setLength(result.length() - 1);

            return result.toString();
        }

        public TreeNode deserialize(String data) {
            if (data.equals("null")) {
                return null;
            }

            String[] nodes = data.split(",");
            Queue<TreeNode> queue = new LinkedList<>();

            TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
            queue.offer(root);

            int i = 1; // Pointer for the child nodes
            while (!queue.isEmpty()) {
                TreeNode parent = queue.poll();

                if (!nodes[i].equals("null")) {
                    parent.left = new TreeNode(Integer.parseInt(nodes[i]));
                    queue.offer(parent.left);
                }
                i++;

                if (i < nodes.length && !nodes[i].equals("null")) {
                    parent.right = new TreeNode(Integer.parseInt(nodes[i]));
                    queue.offer(parent.right);
                }
                i++;
            }

            return root;
        }
    }

    public static void main(String[] args) {
        Codec codec = new Codec();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String serialized = codec.serialize(root);
        System.out.println("Serialized: " + serialized);

        TreeNode deserialized = codec.deserialize(serialized);
        System.out.println("Deserialized: " + codec.serialize(deserialized));

    }
}
