
public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        // Write your logic here
        if(root == null){
            return  0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);


        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {

        MaximumDepthOfBinaryTree solution =
                new MaximumDepthOfBinaryTree();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int result = solution.maxDepth(root);

        System.out.println("Maximum Depth: " + result);
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
