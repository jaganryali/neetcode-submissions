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
    public int maxDepth(TreeNode root) {
        return depth(root);        
    }

    public int depth(TreeNode node) {
        if(node == null) return 0;

        int lDepth = 1 + depth(node.left);
        int rDepth = 1 + depth(node.right);
        return Math.max(lDepth, rDepth);
    }
}
