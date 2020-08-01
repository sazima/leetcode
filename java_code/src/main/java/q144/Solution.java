package q144;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
144. 二叉树的前序遍历
给定一个二叉树，返回它的 前序 遍历。

 示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,2,3]
进阶: 递归算法很简单，你可以通过迭代算法完成吗

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    private List<Integer> result = new ArrayList<>();
    // 递归 0mss
    public List<Integer> preorderTraversal(TreeNode root) {
        helper(root);
        return result;
    }
    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        helper(root.left);
        helper(root.right);
    }

}
