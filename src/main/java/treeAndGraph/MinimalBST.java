package treeAndGraph;

public class MinimalBST {
    public static TreeNode createMinimalBST(int[] arr, int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(arr[mid]);

        node.left = createMinimalBST(arr, start, mid - 1);
        node.right = createMinimalBST(arr, mid + 1, end);

        return node;
    }

    public static TreeNode createMinimalBST(int[] arr) {
        return createMinimalBST(arr, 0, arr.length - 1);
    }
}
