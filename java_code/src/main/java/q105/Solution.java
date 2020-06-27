package q105;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.PropertyResourceBundle;

/*
105. 从前序与中序遍历序列构造二叉树
根据一棵树的前序遍历与中序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

前序遍历 preorder = [3,9,20,15,7]
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

    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        for (int i = 0; i < preOrder.length; i++) {
            inOrderMap.put(inOrder[i], i);
        }
        return helper(preOrder, 0, 0, inOrder.length - 1);
    }

    // 对于任意一颗树而言，前序遍历的形式总是
    //[ 根节点, [左子树的前序遍历结果], [右子树的前序遍历结果] ]
    //即根节点总是前序遍历中的第一个节点。而中序遍历的形式总是
    //[ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]
    private TreeNode helper(int[] preOrder, int preRootIndex, int inStartIndex, int inEndIndex) {
        if (inEndIndex < inStartIndex) {
            return null;
        }
        int rootValue =  preOrder[preRootIndex];
        TreeNode root = new TreeNode(rootValue);
        int inOrderRootIndex = inOrderMap.get(rootValue);
        int leftCount = inOrderRootIndex - inStartIndex;
        root.left = helper(preOrder, preRootIndex + 1, inStartIndex, inOrderRootIndex - 1);
        root.right = helper(preOrder, preRootIndex + leftCount + 1, inOrderRootIndex +1, inEndIndex);
        return root;
    }
}
