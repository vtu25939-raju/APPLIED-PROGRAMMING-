class Solution {
        public int kthSmallest(TreeNode root, int k) {
                Stack<TreeNode> stack = new Stack<>();
                        TreeNode current = root;
                                int count = 0;

                                        while (current != null || !stack.isEmpty()) {
                                                    // Reach the leftmost node of the current subtree
                                                                while (current != null) {
                                                                                stack.push(current);
                                                                                                current = current.left;
                                                                                                            }

                                                                                                                        current = stack.pop();
                                                                                                                                    count++;

                                                                                                                                                // If we've reached the kth element, return it
                                                                                                                                                            if (count == k) {
                                                                                                                                                                            return current.val;
                                                                                                                                                                                        }

                                                                                                                                                                                                    // Move to the right subtree
                                                                                                                                                                                                                current = current.right;
                                                                                                                                                                                                                        }

                                                                                                                                                                                                                                return -1; // Should not be reached per constraints
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                    }
