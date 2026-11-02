

public class ValidateBinarySearchTree {
    public static boolean func(TreeNode root , long min,long max){
        if(root == null){ return true; }

        if(root.val <= min || root.val >= max){
            return false;
        }

        return func(root.left, min, root.val)
    && func(root.right, root.val, max);
    }

    public boolean isValidBST(TreeNode root) {
        // Write your logic here

        return func(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public static void main(String[] args) {

        ValidateBinarySearchTree solution =
                new ValidateBinarySearchTree();

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        boolean result = solution.isValidBST(root);

        System.out.println("Is Valid BST: " + result);
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
