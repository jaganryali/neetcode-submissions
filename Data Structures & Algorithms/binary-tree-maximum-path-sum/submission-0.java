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
    public int maxPathSum(TreeNode root) {

        int[] res = new int[2];
        res[0] = root.val;

        dfs(root, res);

        return res[0];        
    }

    public int dfs(TreeNode node, int[] res) {
        if(node == null) return 0;

        int maxLeft = Math.max(0, dfs(node.left, res));
        int maxRight = Math.max(0, dfs(node.right, res));

        res[0] = Math.max(res[0], node.val + maxLeft + maxRight);

        return node.val + Math.max(maxLeft, maxRight);
    }
}
