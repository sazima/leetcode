package q94;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution2 {

    // 栈
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (true) {
            if (stack.isEmpty() && current == null) {
                break;
            }
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }
        return result;
    }
}
