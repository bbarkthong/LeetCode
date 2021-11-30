/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        boolean ret = true;
        if (root != null)
            ret = toRecur(root.left, root.right);
        return ret;
    }

    protected boolean toRecur(TreeNode left, TreeNode right) {
        boolean ret = false;
        if (left == null || right == null) {
            if (left == null && right == null) {
                return true;
            }
            return false;
        }
        System.out.println(left.val + "-" + right.val);
        if ((left.val == right.val) && toRecur(left.left, right.right) && toRecur(left.right, right.left))
            ret = true;

        return ret;
    }
}
