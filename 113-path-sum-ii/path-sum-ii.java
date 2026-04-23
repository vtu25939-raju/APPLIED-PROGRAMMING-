class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findPaths(root, targetSum, currentPath, result);
        return result;
    }

    private void findPaths(TreeNode root, int remainingSum, List<Integer> currentPath, List<List<Integer>> result) {
        if (root == null) return;

        // Add current node to the path
        currentPath.add(root.val);

        // Check if it's a leaf and the sum matches
        if (root.left == null && root.right == null && remainingSum == root.val) {
            // We must create a NEW list because currentPath keeps changing
            result.add(new ArrayList<>(currentPath));
        } else {
            // Continue exploring left and right
            findPaths(root.left, remainingSum - root.val, currentPath, result);
            findPaths(root.right, remainingSum - root.val, currentPath, result);
        }

        // Backtrack: remove the current node before going back up the tree
        currentPath.remove(currentPath.size() - 1);
    }
}