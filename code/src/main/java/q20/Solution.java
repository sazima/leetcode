package q20;
/*
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：

给定的 n 保证是有效的。

进阶：

你能尝试使用一趟扫描实现吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> pipe = new ArrayList<>();
        boolean pipeFull = false;
        pipe.add(head);

        ListNode node = head;
        ListNode preNode = head;  // 倒数第n+1个;
        while (true) {
            if (null == node.next) {
                break;
            }
            pipe.add(node.next);
            if (pipe.size() > n) {  // 第0个就是倒数第n个
                preNode = pipe.remove(0);  // 被移除的那一个, 可能是倒数第n个的前一个
                pipeFull = true;
            }
            node = node.next;
        }
        if (pipeFull) {  // 满
            if (n == 1) {
                preNode.next = null;
            } else {
                preNode.next = pipe.get(1);
            }
            return head;
        } else {
            // [12,3],  2
            if (pipe.size() == n && n != 1) {
                return pipe.get(1);
            }
            if (n == 1) {
                return null;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        ListNode listNode = s.removeNthFromEnd(n1, 2);
        System.out.println(listNode.val);
        System.out.println(listNode.next.val);
    }
}
