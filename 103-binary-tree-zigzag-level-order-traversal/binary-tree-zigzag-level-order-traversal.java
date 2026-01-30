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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         List<List<Integer>> res = new ArrayList<>();
        dfs(root,0,res);
        return res;
    }
    private void dfs(TreeNode node, int level, List<List<Integer>> res) {
        if (node == null) return;

        if (res.size() == level) {
            res.add(new LinkedList<>());
        }

        // Zigzag logic
        if (level % 2 == 0) {
            res.get(level).add(node.val);      // left → right
        } else {
            res.get(level).add(0, node.val);   // right → left
        }

        dfs(node.left, level + 1, res);
        dfs(node.right, level + 1, res);
    }   
}