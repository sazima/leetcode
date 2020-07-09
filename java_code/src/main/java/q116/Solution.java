package q116;

import com.sun.tools.corba.se.idl.StringGen;
import sun.java2d.pipe.SpanClipRenderer;
import utils.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。

初始状态下，所有 next 指针都被设置为 NULL。

 

示例：
(此处有两张图)


输入：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":{"$id":"6","left":null,"next":null,"right":null,"val":6},"next":null,"right":{"$id":"7","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}

输出：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":{"$id":"6","left":null,"next":null,"right":null,"val":7},"right":null,"val":6},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"7","left":{"$ref":"5"},"next":null,"right":{"$ref":"6"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"7"},"val":1}

解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 

提示：

你只能使用常量级额外空间。
使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    // 1ms  55%, 空间复杂度不满足要求
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
//        ArrayList<Node> preList = new ArrayList<>();
        Node[] preNodes = new Node[1];
        preNodes[0] = root;
        while (true) {
            Node[] tempNodes = new Node[preNodes.length * 2];

            Node preRight = null;
            boolean isEmpty = false;
            int j = 0;
            for (int i = 0; i < preNodes.length; i++) {
                Node node = preNodes[i];
                Node left = node.left;
                if (left == null) {
                    isEmpty = true;
                    break;
                }
                if (preRight != null) {
                    preRight.next = left;
                }
                Node right = node.right;
                left.next = right;

                tempNodes[j] = left;
                j++;
                tempNodes[j] = right;
                j++;
                preRight = right;
            }
            if (isEmpty) {
                break;
            }
            preNodes = tempNodes;
        }
        return root;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
//        Node node8 = new Node(8);
        node.left = node2;
        node.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        Solution s = new Solution();
        Node result = s.connect(node);
    }
}
