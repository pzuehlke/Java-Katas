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
    public boolean isSymmetric(TreeNode root) {
        return isEqual(root, invertTree(root));
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) { return null; }

        TreeNode invertedTree = new TreeNode();
        invertedTree.val = root.val;
        invertedTree.right = invertTree(root.left);
        invertedTree.left = invertTree(root.right);
        return invertedTree;
    }

    public boolean isEqual(TreeNode root1, TreeNode root2) {
        if (root1 == null ^ root2 == null) {
            return false;
        }
        else if (root1 == null && root2 == null) {
            return true;
        }
        else if (root1.val == root2.val) {
            return (isEqual(root1.left, root2.left)
                    && isEqual(root1.right, root2.right));
        }
        else {
            return false;
        }
    }
}