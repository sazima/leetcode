package q107;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
二叉树的层次遍历 II
给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其自底向上的层次遍历为：

[
  [15,7],
  [9,20],
  [3]
]
 */
public class Solution {
    //
//2 ms
//, 在所有 Java 提交中击败了
//24.45%

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (null == root) {
            return new ArrayList<>();
        }
        List<TreeNode> preTreeNodeArrayList = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        result.add(Collections.singletonList(root.val));

        preTreeNodeArrayList.add(root);
        while (true) {
            ArrayList<Integer> currentResult = new ArrayList<>();
            ArrayList<TreeNode> tempPreTreeNodeList = new ArrayList<>();
            for (TreeNode r : preTreeNodeArrayList) {
                if (r.left != null) {
                    tempPreTreeNodeList.add(r.left);
                    currentResult.add(r.left.val);
                }
                if (r.right != null) {
                    tempPreTreeNodeList.add(r.right);
                    currentResult.add(r.right.val);
                }
            }
            if (currentResult.size() == 0) {
                break;
            }
            preTreeNodeArrayList = tempPreTreeNodeList;
            result.add(0, currentResult);
        }
        Collections.reverse(result);
        return result;
    }
}
