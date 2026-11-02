
import java.util.*;

public class BinaryTreeRightSideView {
    // leetcode 199

    public List<Integer> rightSideView(TreeNode root) {
        // Write your BFS / DFS logic here
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Integer> result = new ArrayList<>();

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0 ; i<size ; i++){
                TreeNode node = q.poll();

                if(i == size - 1){
                    result.add(node.val);
                }

                if(node.left != null){
                    q.add(node.left);
                }

                if(node.right != null){
                    q.add(node.right);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        BinaryTreeRightSideView solution =
                new BinaryTreeRightSideView();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(4);

        List<Integer> result = solution.rightSideView(root);

        System.out.println("Right Side View: " + result);
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
