package q116;

import utils.Node;

public class Solution2 {
    // 0ms 100%, 空间复杂度满足
    public Node connect(Node root) {
        if (null == root) {
            return null;
        }
        Node leftNode = root;
        while (true) {
            if (leftNode.left == null) {
                break;
            }
            Node nodeItem = leftNode;
            while (true) {
                nodeItem.left.next = nodeItem.right;
                if (nodeItem.next != null) {
                    nodeItem.right.next = nodeItem.next.left;
                } else  {
                    break;
                }
                nodeItem = nodeItem.next;
            }
            leftNode = leftNode.left;
        }
        return root;
    }

}
