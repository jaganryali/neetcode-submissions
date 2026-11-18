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
    public TreeNode invertTree(TreeNode root) {
        return traverse(root);
    }

    public TreeNode traverse(TreeNode node) {
        if(node == null) return null;

        TreeNode nleft = traverse(node.right);
        TreeNode nright = traverse(node.left);
        node.left = nleft;
        node.right = nright;
        return node;
    }
}
