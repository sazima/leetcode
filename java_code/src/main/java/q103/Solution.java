package q103;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
103. 二叉树的锯齿形层次遍历
给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回锯齿形层次遍历如下：

[
  [3],
  [20,9],
  [15,7]
]
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(Collections.singletonList(root.val));
        List<TreeNode> preNodeList = Collections.singletonList(root);
        boolean reverse = true;  // 第一行已经遍历完, 第二行为反向
        while (true) {
            List<Integer> tempResultValue = new ArrayList<>();
            ArrayList<TreeNode> tempPreNodeList = new ArrayList<>();
            if (!reverse) {  // 正
                for (int i = preNodeList.size() - 1; i >= 0; i--) {
                    TreeNode r = preNodeList.get(i);
                    if (r.left != null) {
                        tempResultValue.add(r.left.val);
                        tempPreNodeList.add(r.left);
                    }
                    if (r.right != null) {
                        tempResultValue.add(r.right.val);
                        tempPreNodeList.add(r.right);
                    }
                }
            } else {  // 反
                for (int i = preNodeList.size() - 1; i >= 0; i--) {
                    TreeNode r = preNodeList.get(i);
                    if (r.right != null) {
                        tempResultValue.add(r.right.val);
                        tempPreNodeList.add(r.right);
                    }
                    if (r.left != null) {
                        tempResultValue.add(r.left.val);
                        tempPreNodeList.add(r.left);
                    }

                }
            }
            if (tempPreNodeList.size() == 0) {
                break;
            }
            result.add(new ArrayList<>(tempResultValue));
            preNodeList = tempPreNodeList;
            reverse = !reverse;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);
        r1.left = r2;
        r1.right = r3;
        r2.left = r4;
        r3.left = r5;
        List<List<Integer>> res = s.zigzagLevelOrder(r1);
        System.out.println(res);
    }
}
