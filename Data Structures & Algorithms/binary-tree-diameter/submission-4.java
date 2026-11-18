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
    private int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxDiameter;
    }

    public int depth(TreeNode node) {
        if(node == null) return 0;

        int lh = depth(node.left);
        int rh = depth(node.right);

        maxDiameter = Math.max(lh + rh, maxDiameter);

        return 1 + Math.max(lh, rh);
    }
}
