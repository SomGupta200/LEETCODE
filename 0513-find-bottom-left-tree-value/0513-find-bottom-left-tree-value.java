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
    public int findBottomLeftValue(TreeNode root) {
          Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        TreeNode temp = null;
        
        while (!q.isEmpty()) {
            temp = q.remove();
            
            // push right first
            if (temp.right != null) q.add(temp.right);
            if (temp.left != null) q.add(temp.left);
        }
        
        return temp.val;
    }
}