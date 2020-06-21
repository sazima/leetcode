package q98;

import utils.TreeNode;

public class Solution {
    // 递归 0ms
    public boolean isValidBST(TreeNode root) {
        if (null == root) {
            return false;
        }
        return helper(root, new Integer[]{null, null});
    }

    private boolean helper(TreeNode root, Integer[] minMax) {
        if ((minMax[0] != null && root.val <= minMax[0]) || (minMax[1] != null && root.val >= minMax[1])) {
            return false;
        }
        if (root.left != null) {
            boolean res = helper(root.left, new Integer[]{minMax[0], root.val});
            if (!res) {
                return false;
            }
        }
        if (root.right != null) {
            boolean res = helper(root.right, new Integer[]{root.val, minMax[1]});
            if (!res) {
                return false;
            }
        }
        return true;
    }
}
