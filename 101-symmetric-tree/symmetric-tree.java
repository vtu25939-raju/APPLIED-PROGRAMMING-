class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        // If both are null, they are mirrors
        if (t1 == null && t2 == null) return true;
        // If only one is null, they aren't mirrors
        if (t1 == null || t2 == null) return false;
        
        // Check if values match AND if children are mirrors (outer and inner)
        return (t1.val == t2.val)
            && isMirror(t1.right, t2.left)
            && isMirror(t1.left, t2.right);
    }
}