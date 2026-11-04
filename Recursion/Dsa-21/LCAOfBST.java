public class LCAOfBST {

    public TreeNode lowestCommonAncestor(
            TreeNode root, TreeNode p, TreeNode q) {

        // Write your logic here

        while(root != null){
            if(root.val > p.val && root.val > q.val){
                root = root.left;
            }else if(root.val < p.val && root.val < q.val){
                root = root.right;
            }else {
                return root;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        LCAOfBST solution = new LCAOfBST();

        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        TreeNode p = root.left;
        TreeNode q = root.right;

        TreeNode result = solution.lowestCommonAncestor(root, p, q);

        System.out.println(result != null ? result.val : "null");
    }
}

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}