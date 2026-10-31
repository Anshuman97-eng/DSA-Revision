
public class BalancedBinaryTree {

    public int solve(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = solve(root.left);
        if(left == -1){
            return -1;
        }

        int right = solve(root.right);
        if(right == -1){
            return -1;
        }

        if(Math.abs(left - right) > 1){
            return  -1;
        }

        return 1 + Math.max(left,right);
    }

    public boolean isBalanced(TreeNode root) {
        // Write your logic here
        int val = solve(root);

        return val != -1;
    }

    public static void main(String[] args) {

        BalancedBinaryTree solution =
                new BalancedBinaryTree();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        boolean result = solution.isBalanced(root);

        System.out.println("Is Balanced: " + result);
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
