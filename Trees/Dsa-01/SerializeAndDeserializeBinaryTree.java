import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

    // Serialization
    public String serialize(TreeNode root) {

        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {

            TreeNode node = q.poll();

            if (node == null) {
                sb.append("null,");
                continue;
            }

            sb.append(node.val).append(",");

            q.add(node.left);
            q.add(node.right);
        }

        return sb.toString();
    }

    // Deserialization
    public TreeNode deserialize(String data) {

        if (data == null || data.isEmpty()) {
            return null;
        }

        String[] str = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();

        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        q.add(root);

        int i = 1;

        while (!q.isEmpty() && i < str.length) {

            TreeNode node = q.poll();

            // Left child
            if (i < str.length && !str[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(str[i]));
                q.add(node.left);
            }
            i++;

            // Right child
            if (i < str.length && !str[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(str[i]));
                q.add(node.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {

        SerializeAndDeserializeBinaryTree solution =
                new SerializeAndDeserializeBinaryTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        // Serialization
        String data = solution.serialize(root);
        System.out.println("Serialized: " + data);

        // Deserialization
        TreeNode result = solution.deserialize(data);

        System.out.println("Deserialized Root: " +
                (result != null ? result.val : "null"));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}