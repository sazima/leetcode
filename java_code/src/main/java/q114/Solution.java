package q114;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
114. 二叉树展开为链表
给定一个二叉树，原地将它展开为一个单链表。



例如，给定二叉树

    1
   / \
  2   5
 / \   \
3   4   6
将其展开为：

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
 */
public class Solution {
    // 5ms, 11%
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        ArrayList<Integer> nums = new ArrayList<>();
        leftRead(root, nums);
        System.out.println(nums);
        TreeNode head = root;
        for (int num: nums) {
            head.right = new TreeNode(num);
            head = head.right;
        }
        root.left = null;
    }
    public void leftRead(TreeNode root, List<Integer> result) {
        if (root.left != null) {
            result.add(root.left.val);
            leftRead(root.left, result);
        }
        if (root.right != null) {
            result.add(root.right.val);
            leftRead(root.right, result);
        }

    }

    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        r3.left = new TreeNode(4);
        r1.left = r2;
        r1.right = r3;
        Solution s = new Solution();
    }
}
