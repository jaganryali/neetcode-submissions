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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.add(root);


        while (!queue.isEmpty()){
            List<Integer> item = new ArrayList<>();

            for(int i = queue.size(); i > 0; i--){
                TreeNode tmp = queue.poll();
                if(tmp != null) {
                    item.add(tmp.val);
                    queue.add(tmp.left);
                    queue.add(tmp.right);
                }
            }
            if(!item.isEmpty()) {
                result.add(item);
            }
        }
        return result;        
    }
}
