
import java.util.*;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        // Write your BFS logic here
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            List<Integer> list = new ArrayList<>();

            for(int i=0 ; i<size ; i++){
                TreeNode node = q.poll();
                list.add(node.val);
                if(node.left != null){
                    q.add(node.left);
                }

                if(node.right != null){
                    q.add(node.right);
                }

            }

            result.add(new ArrayList<>(list));
        }

        return result;
    }

    public static void main(String[] args) {

        BinaryTreeLevelOrderTraversal solution =
                new BinaryTreeLevelOrderTraversal();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = solution.levelOrder(root);

        System.out.println("Level Order: " + result);
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
