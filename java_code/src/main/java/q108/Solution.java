package q108;

import utils.TreeNode;

/*
108. 将有序数组转换为二叉搜索树
将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

示例:

给定有序数组: [-10,-3,0,5,9],

一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5
 */
public class Solution {
    // 递归 0ms
    public TreeNode sortedArrayToBST(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        return help(l, r, nums);


    }

    private TreeNode help(int l, int r, int[] nums) {
        if (l > r) {
            return null;
        }
        int mid = (l + r) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = help(l, mid -1, nums);
        root.right = help(mid + 1, r, nums);
        return root;
    }

}

