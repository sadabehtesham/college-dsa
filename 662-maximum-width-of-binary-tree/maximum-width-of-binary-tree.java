/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 class Solution {

    long maxWidth = 0;
    Map<Integer, Long> firstIndexAtDepth = new HashMap<>();

    public int widthOfBinaryTree(TreeNode root) {
        dfs(root, 0, 0);
        return (int) maxWidth;
    }

    private void dfs(TreeNode node, int depth, long index) {
        if (node == null) return;

        // If this is the first node at this depth
        firstIndexAtDepth.putIfAbsent(depth, index);

        long firstIndex = firstIndexAtDepth.get(depth);
        long width = index - firstIndex + 1;
        maxWidth = Math.max(maxWidth, width);

        dfs(node.left, depth + 1, 2 * index);
        dfs(node.right, depth + 1, 2 * index + 1);
    }
}
