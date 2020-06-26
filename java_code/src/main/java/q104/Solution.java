package q104;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
二叉树的最大深度
给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点。

示例：
给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度 3 。
 */
public class Solution {
    // 2ms
    public int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        List<List<TreeNode>> treeNodesLevels = new ArrayList<>();
        treeNodesLevels.add(Collections.singletonList(root));
        while (true) {
            List<TreeNode> tempPreTreeNodes = new ArrayList<>();
            for (TreeNode t: treeNodesLevels.get(treeNodesLevels.size() - 1) ) {
                if (t.left != null) {
                    tempPreTreeNodes.add(t.left);
                }
                if (t.right != null) {
                    tempPreTreeNodes.add(t.right);
                }
            }
            if (tempPreTreeNodes.size() == 0) {
                break;
            }
            treeNodesLevels.add(tempPreTreeNodes);
        }
        return treeNodesLevels.size();
    }

    // 0ms
    public int maxDepth2(TreeNode root) {
       if (null == root)  {
           return 0;
       }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

}

