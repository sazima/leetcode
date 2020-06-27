package q106;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/*
106. 从中序与后序遍历序列构造二叉树
根据一棵树的中序遍历与后序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

后序遍历 postorder = [9,15,7,20,3]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7
 */
public class Solution {
    private Map<Integer, Integer> inOrderMap = new HashMap<>();

    public TreeNode buildTree(int[] inOrder, int[] postOrder) {
        for (int i = 0; i<inOrder.length; i++) {
            inOrderMap.put(inOrder[i], i);
        }
        return helper(postOrder, postOrder.length - 1, 0, inOrder.length - 1);
    }

    private TreeNode helper(int[] postOrder, int postRootIndex, int inOrderStart, int inOrderEnd) {
        if (inOrderStart > inOrderEnd) {
            return null;
        }
        int rootValue = postOrder[postRootIndex];
        int inOrderRootIndex = inOrderMap.get(rootValue);
        int rightCount = inOrderEnd - inOrderRootIndex;
        TreeNode root = new TreeNode(rootValue);
        root.left = helper(postOrder, postRootIndex - 1 - rightCount, inOrderStart, inOrderRootIndex - 1);
        root.right = helper(postOrder, postRootIndex - 1, inOrderRootIndex + 1, inOrderEnd);
        return root;
    }
}
