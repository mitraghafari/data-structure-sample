package treeAndGraph;

public class OptimizedBalancedTree {
    public static int checkHeight(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = checkHeight(root.left);
        if (leftHeight == -1) return -1; // Left subtree not balanced

        int rightHeight = checkHeight(root.right);
        if (rightHeight == -1) return -1; // Right subtree not balanced

        if (Math.abs(leftHeight - rightHeight) > 1) return -1; // Not balanced

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }
}
