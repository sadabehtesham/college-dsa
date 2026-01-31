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

    static class NodeInfo {
        int col, row, val;
        NodeInfo(int c, int r, int v) {
            col = c;
            row = r;
            val = v;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<NodeInfo> list = new ArrayList<>();
        dfs(root, 0, 0, list);

        // Sort by col, then row, then value
        Collections.sort(list, (a, b) -> {
            if (a.col != b.col) return a.col - b.col;
            if (a.row != b.row) return a.row - b.row;
            return a.val - b.val;
        });

        List<List<Integer>> res = new ArrayList<>();
        int prevCol = Integer.MIN_VALUE;

        for (NodeInfo n : list) {
            if (n.col != prevCol) {
                res.add(new ArrayList<>());
                prevCol = n.col;
            }
            res.get(res.size() - 1).add(n.val);
        }

        return res;
    }

    private void dfs(TreeNode node, int row, int col, List<NodeInfo> list) {
        if (node == null) return;

        list.add(new NodeInfo(col, row, node.val));

        dfs(node.left, row + 1, col - 1, list);
        dfs(node.right, row + 1, col + 1, list);
    }
}
