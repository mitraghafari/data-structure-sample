package treeAndGraph;

class TreeNode {
    int value;
    TreeNode left, right;

    public TreeNode(int value) {
        this.value = value;
        left = right = null;
    }
}

public class BalancedTree {
    public static int getHeight(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true; // Base case

        int heightDiff = getHeight(root.left) - getHeight(root.right);
        if (Math.abs(heightDiff) > 1) return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }
}
