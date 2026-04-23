class Solution {
    class NodeInfo {
        int row, col, val;
        NodeInfo(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<NodeInfo> nodes = new ArrayList<>();
        dfs(root, 0, 0, nodes);

        // Sort by: Column -> Row -> Value
        Collections.sort(nodes, (a, b) -> {
            if (a.col != b.col) return a.col - b.col;
            if (a.row != b.row) return a.row - b.row;
            return a.val - b.val;
        });

        List<List<Integer>> result = new ArrayList<>();
        if (nodes.isEmpty()) return result;

        // Group by column
        int lastCol = nodes.get(0).col;
        List<Integer> currentColumn = new ArrayList<>();
        
        for (NodeInfo node : nodes) {
            if (node.col != lastCol) {
                result.add(currentColumn);
                currentColumn = new ArrayList<>();
                lastCol = node.col;
            }
            currentColumn.add(node.val);
        }
        result.add(currentColumn); // Add the final column

        return result;
    }

    private void dfs(TreeNode root, int row, int col, List<NodeInfo> nodes) {
        if (root == null) return;
        nodes.add(new NodeInfo(row, col, root.val));
        dfs(root.left, row + 1, col - 1, nodes);
        dfs(root.right, row + 1, col + 1, nodes);
    }
}