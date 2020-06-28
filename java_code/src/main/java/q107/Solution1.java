package q107;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution1 {
    // 递归1ms, 98%
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (null == root) {
            return new ArrayList<>();
        }
        ArrayList<List<Integer>> result = new ArrayList<>();
        find(root, 1, result);
        return result;
    }

    private void find(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        if (level > result.size()) {
            result.add(0, new ArrayList<>());
        }
        result.get(0).add(root.val);
        find(root.left, level + 1, result);
        find(root.right, level + 1, result);

    }


}
