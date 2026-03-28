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
    public int amountOfTime(TreeNode root, int start) {
          // Step 1: Map child -> parent
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        TreeNode startNode = buildParentMap(root, parentMap, start);

        // Step 2: BFS from start node
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        q.add(startNode);
        visited.add(startNode);

        int time = -1;

        while (!q.isEmpty()) {
            int size = q.size();
            time++;

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                // left
                if (node.left != null && !visited.contains(node.left)) {
                    visited.add(node.left);
                    q.add(node.left);
                }

                // right
                if (node.right != null && !visited.contains(node.right)) {
                    visited.add(node.right);
                    q.add(node.right);
                }

                // parent
                if (parentMap.containsKey(node) && !visited.contains(parentMap.get(node))) {
                    visited.add(parentMap.get(node));
                    q.add(parentMap.get(node));
                }
            }
        }

        return time;
    }

    // Helper to build parent map + find start node
    private TreeNode buildParentMap(TreeNode root, Map<TreeNode, TreeNode> parentMap, int start) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        TreeNode startNode = null;

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node.val == start) {
                startNode = node;
            }

            if (node.left != null) {
                parentMap.put(node.left, node);
                q.add(node.left);
            }

            if (node.right != null) {
                parentMap.put(node.right, node);
                q.add(node.right);
            }
        }

        return startNode;
    }
}