
public class DiameterOfBinaryTree {
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        // Write your logic here
          if(root == null){
            return 0;
        }

        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);

        diameter = Math.max(diameter,left + right);
        return 1 + Math.max(left,right);
    }

    public static void main(String[] args) {

        DiameterOfBinaryTree solution =
                new DiameterOfBinaryTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int result = solution.diameterOfBinaryTree(root);

        System.out.println("Diameter: " + result);
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
