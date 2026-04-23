class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root != null) {
            dfs(root, "", result);
        }
        return result;
    }

    private void dfs(TreeNode node, String path, List<String> result) {
        // Append current node value to the path string
        path += node.val;

        // If it's a leaf, add the complete path to our result list
        if (node.left == null && node.right == null) {
            result.add(path);
        } else {
            // If not a leaf, add the arrow and continue to children
            if (node.left != null) dfs(node.left, path + "->", result);
            if (node.right != null) dfs(node.right, path + "->", result);
        }
    }
}