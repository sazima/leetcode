package q109;

import utils.ListNode;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
109. 有序链表转换二叉搜索树
给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

示例:

给定的有序链表： [-10, -3, 0, 5, 9],

一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5
 */
public class Solution {
    // 1ms 70%
    // 遍历链表后,使用二分递归
    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> integers = new ArrayList<>();
        ListNode current = head;
        while (null != current) {
            integers.add(current.val);
            current = current.next;
        }
        int l = 0;
        int r = integers.size() - 1;
        return buildTree(integers, l, r);
    }

    private TreeNode buildTree(List<Integer> nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = (l + r) / 2;
        Integer num = nums.get(mid);
        TreeNode root = new TreeNode(num);
        root.left = buildTree(nums, l, mid - 1);
        root.right = buildTree(nums, mid + 1, r);
        return root;
    }
}
