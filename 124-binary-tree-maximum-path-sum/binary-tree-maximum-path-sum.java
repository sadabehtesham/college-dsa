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
    int maxsum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        path(root);
        return maxsum;
    }
    public int path(TreeNode node){
        if(node==null){
            return 0;
        }
        int l=Math.max(0,path(node.left));
        int r=Math.max(0,path(node.right));
        int currsum=node.val+l+r;
        maxsum=Math.max(currsum,maxsum);
        return node.val+Math.max(l,r);
    }
}