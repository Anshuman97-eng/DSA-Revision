public class BinaryTreeMaximumPathSum {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        // Write your logic here
        findMaxPath(root);

        return maxSum;
    }

    public int findMaxPath(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = Math.max(0, findMaxPath(root.left));
        int right = Math.max(0, findMaxPath(root.right));

        int first = left + right + root.val;
        int second = Math.max(left, right) + root.val;

        maxSum = Math.max(maxSum, first);

        return second;
    }

    public static void main(String[] args) {

        BinaryTreeMaximumPathSum solution =
                new BinaryTreeMaximumPathSum();

        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int result = solution.maxPathSum(root);

        System.out.println("Maximum Path Sum: " + result);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}