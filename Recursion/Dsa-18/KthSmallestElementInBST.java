import java.util.*;

public class KthSmallestElementInBST {

    public static void func(TreeNode root ,List<Integer> list){
        if(root == null){
            return;
        }

        func(root.left, list);
        list.add(root.val);
        func(root.right, list);
    }

    public int kthSmallest(TreeNode root, int k) {
        // Write your logic here
        List<Integer> list = new ArrayList<>();
        func(root,list);

        return list.get(k - 1);
    }

    public static void main(String[] args) {

        KthSmallestElementInBST solution =
                new KthSmallestElementInBST();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        int k = 1;

        int result = solution.kthSmallest(root, k);

        System.out.println("Kth Smallest: " + result);
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