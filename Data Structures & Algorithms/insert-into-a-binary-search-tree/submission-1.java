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
    public TreeNode insertIntoBST(TreeNode root, int val) {

        
        if(root == null){
            return new TreeNode(val);
        }
        TreeNode curr = root;
        TreeNode parent = null;

        while(curr != null) {
            parent = curr;
            if(val > curr.val) {
                curr = curr.right;
            }
            else {
                curr = curr.left;
            }
        }

        if( val > parent.val) {
            parent.right = new TreeNode(val);
        }else {
            parent.left = new TreeNode(val);
        }
        return root;
        
    }
}