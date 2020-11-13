package q173;


import java.security.PublicKey;
import java.util.Stack;

/**
 * 173. 二叉搜索树迭代器
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 * <p>
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // 返回 3
 * iterator.next();    // 返回 7
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 9
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 15
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 20
 * iterator.hasNext(); // 返回 false
 * <p>
 * <p>
 * 提示：
 * <p>
 * next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。
 * 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

// 23ms 82.61%
public class BSTIterator {

    TreeNode root;

    Stack<Integer> value = new Stack<Integer>();

    public BSTIterator(TreeNode root) {
        this.root = root;
        help(root);
    }

    public void help(TreeNode node) {
        if (node == null) {
            return;
        }
        help(node.right);
        value.push(node.val);
        help(node.left);
    }

    public int next() {
        return value.pop();
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !value.isEmpty();
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(7);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(9);
        TreeNode node5 = new TreeNode(20);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        BSTIterator iterator = new BSTIterator(node1);
        assert iterator.next() == 3;
        assert iterator.next() == 7;    // 返回 7
        assert iterator.hasNext(); // 返回 true
        assert iterator.next() == 9;    // 返回 9
        assert iterator.hasNext(); // 返回 true
        assert iterator.next() == 15;    // 返回 15
        assert iterator.hasNext(); // 返回 true
        assert iterator.next() == 20;    // 返回 20
        assert !iterator.hasNext(); // 返回 false
    }
}
