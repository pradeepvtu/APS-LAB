import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Edge case: if tree is empty
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of nodes at the current level
            List<Integer> currentLevelNodes = new ArrayList<>();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevelNodes.add(currentNode.val);
                
                // Add left child to queue if it exists
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                
                // Add right child to queue if it exists
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            
            // Add the level list to our final result
            result.add(currentLevelNodes);
        }
        
        return result;
    }
}
