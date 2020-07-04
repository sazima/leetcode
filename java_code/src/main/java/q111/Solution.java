package q111;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*

给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

说明: 叶子节点是指没有子节点的节点。

示例:

给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
 */
public class Solution {
    // 1 ms
    //, 在所有 Java 提交中击败了
    //16.54%
    public int minDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        List<TreeNode> pre = new ArrayList<>();
        pre.add(root);
        int result = 1;
        while (true) {
            ArrayList<TreeNode> temp = new ArrayList<>();
            for (TreeNode treeNode: pre) {
                boolean hasLeaf = false;
                if (treeNode.left != null) {
                    temp.add(treeNode.left);
                    hasLeaf = true;
                }
                if (treeNode.right != null) {
                    temp.add(treeNode.right);
                    hasLeaf = true;
                }
                if (!hasLeaf) {
                    return result;
                }
            }
            pre = temp;
            result ++;
        }
    }

}
