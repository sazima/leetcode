package q101;

import utils.TreeNode;

/*
101. 对称二叉树
给定一个二叉树，检查它是否是镜像对称的。



例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3


但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3

 */
public class Solution {
    // 递归 0ms
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode l = root.left;
        TreeNode r = root.right;
        return isEqual(l, r);
    }

    public boolean isEqual(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if ((left == null && right != null) || (left != null && right == null)) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        boolean isEqual = isEqual(left.left, right.right);
        if (!isEqual) {
            return false;
        }
        boolean isEqual1 = isEqual(left.right, right.left);
        if (!isEqual1) {
            return false;
        }
        return true;

    }
}
