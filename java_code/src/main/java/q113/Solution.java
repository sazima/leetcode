package q113;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。

说明: 叶子节点是指没有子节点的节点。

示例:
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:

[
   [5,4,11,2],
   [5,8,4,5]
]
 */
public class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    // 2 ms 52% , 回溯法
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }
        pathSum(root, sum, new ArrayList<>());
        return result;
    }

    private void pathSum(TreeNode root, int sum, List<Integer> currentResult) {
        boolean isLeaf = true;
        currentResult.add(root.val);
        if (root.left != null) {
            pathSum(root.left, sum - root.val, currentResult);
            isLeaf = false;
        }
        if (root.right != null) {
            pathSum(root.right, sum - root.val, currentResult);
            isLeaf = false;
        }
        if (isLeaf && sum == root.val) {
            result.add(new ArrayList<>(currentResult));
        }
        currentResult.remove(currentResult.size() - 1);
    }
    public static void main(String[] args) {

        TreeNode r1 = new TreeNode(5);
        TreeNode r2 = new TreeNode(4);
        TreeNode r3 = new TreeNode(11);
        TreeNode r4 = new TreeNode(2);
        r1.left = r2;
        r2.left = r3;
        r3.left = r4;
        Solution solution = new Solution();
        List<List<Integer>> result = solution.pathSum(r1, 22);
        System.out.println(result);


    }
}
