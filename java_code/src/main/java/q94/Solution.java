package q94;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
给定一个二叉树，返回它的中序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    // 递归
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        helper(root, result);
        return result;
    }

    private void helper(TreeNode root, List<Integer> result) {
        if (root.left != null) {
            helper(root.left, result);
        }
        result.add(root.val);
        if (root.right != null) {
            helper(root.right, result);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = TreeNode.fromArray(new Integer[]{1, null, 2, 3});
        List<Integer> res = solution.inorderTraversal(root);
        System.out.println(res);
    }
}
