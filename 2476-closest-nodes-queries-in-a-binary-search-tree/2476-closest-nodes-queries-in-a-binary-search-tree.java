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
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> inorder = new ArrayList<>();
        inorderTraversal(root , inorder);

        List<List<Integer>> ans = new ArrayList<>();
        for(int q : queries){
            int floor = findFloor(inorder , q);
            int ceil = findCeil(inorder , q);
            ans.add(Arrays.asList(floor , ceil));
        }
        return ans;
    }
    private void inorderTraversal(TreeNode root , List<Integer> list){
        if(root == null) return;
        inorderTraversal(root.left , list);
        list.add(root.val);
        inorderTraversal(root.right , list);
    }
    private int findFloor(List<Integer> list , int x){
        int l = 0 , r = list.size() -1;
        int ans = -1;
        while(l <= r){
            int mid = (l + r) / 2;
            if(list.get(mid) <= x){
                ans = list.get(mid);
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return ans;
    }
    private int findCeil(List<Integer> list , int x){
        int l = 0 , r = list.size() - 1;
        int ans = -1;
        while(l <= r){
            int mid = (l+r) / 2;
            if(list.get(mid) >= x){
                ans = list.get(mid);
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return ans;
    }
}