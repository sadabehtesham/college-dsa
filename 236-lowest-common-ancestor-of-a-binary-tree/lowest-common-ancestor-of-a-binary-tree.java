/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       return lca(root,p,q);
    }
    public TreeNode lca(TreeNode node,TreeNode n1, TreeNode n2){
        if(node==null || node==n1 || node==n2){
            return node;
        }
        TreeNode l=lca(node.left,n1,n2);
        TreeNode r=lca(node.right,n1,n2);
        if(l!=null && r==null){
            return l;
        }
        if(r!=null && l==null){
            return r;
        }
        if(l!=null && r!=null){
            return node;
        }
        return null;
    }
}