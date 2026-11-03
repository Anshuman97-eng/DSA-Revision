public class DeleteNodeInBST {

    public static TreeNode postSuccesor(TreeNode root) {
        TreeNode rightTreeNode = root;

        while (rightTreeNode.left != null) {
            rightTreeNode = rightTreeNode.left;
        }

        return rightTreeNode;
    }

    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) {
            return null;
        }

        if (root.val < key) {
            root.right = deleteNode(root.right, key);

        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);

        } else {

            if (root.left == null && root.right == null) {
                return null;

            } else if (root.left == null) {
                return root.right;

            } else if (root.right == null) {
                return root.left;

            } else {
                TreeNode node = postSuccesor(root.right);
                root.val = node.val;
                root.right = deleteNode(root.right, node.val);
            }
        }

        return root;
    }

    // Print tree using inorder traversal
    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }

        printTree(root.left);
        System.out.print(root.val + " ");
        printTree(root.right);
    }

    public static void main(String[] args) {

        DeleteNodeInBST solution = new DeleteNodeInBST();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        int key = 3;

        TreeNode result = solution.deleteNode(root, key);

        System.out.print("After deleting " + key + ": ");
        printTree(result);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}