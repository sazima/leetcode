package q102;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
102. 二叉树的层序遍历
给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。



示例：
二叉树：[3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [9,20],
  [15,7]
]
 */
public class Solution {
    // 1ms
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(Collections.singletonList(root.val));
        List<TreeNode> preNodeList = Collections.singletonList(root);
        while (true) {
            List<Integer> tempResultValue = new ArrayList<>();
            ArrayList<TreeNode> tempPreNodeList = new ArrayList<>();
            for (TreeNode r: preNodeList) {
                if (r.left != null) {
                    tempResultValue.add(r.left.val);
                    tempPreNodeList.add(r.left);
                }
                if (r.right != null) {
                    tempResultValue.add(r.right.val);
                    tempPreNodeList.add(r.right);
                }
            }
            if (tempPreNodeList.size() == 0) {
                break;
            }
            result.add(new ArrayList<>(tempResultValue));
            preNodeList = tempPreNodeList;
        }
        return result;
    }

}
