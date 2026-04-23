class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            // Reach the left most node of the current node
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            
            // Backtrack from the empty left child
            curr = stack.pop();
            res.add(curr.val); // Add the node value
            
            // We have visited the node and its left subtree. 
            // Now, it's the right subtree's turn.
            curr = curr.right;
        }
        return res;
    }
}