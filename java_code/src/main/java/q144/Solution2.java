package q144;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution2 {
    // 迭代1ms
    public List<Integer> preorderTraversal(TreeNode root) {
        if(null == root) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return result;
    }
}
