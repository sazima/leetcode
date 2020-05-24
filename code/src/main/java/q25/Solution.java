package q25;

import utils.ListNode;

/*
给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
k 是一个正整数，它的值小于或等于链表的长度。
如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
示例：
给你这个链表：1->2->3->4->5
当 k = 2 时，应当返回: 2->1->4->3->5
当 k = 3 时，应当返回: 3->2->1->4->5
说明：
你的算法只能使用常数的额外空间。
你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode resultHead = new ListNode(0);
        resultHead.next = head;

        ListNode pre = resultHead;
        ListNode end = resultHead;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            };
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;

            end = pre;
        }
        return resultHead.next;

    }

    // 翻转链表
    private ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode pre = null;
        while (true) {
            if (current == null) {
                return pre;
            }
            // 遍历到第二个的时候, 第二个指向第一个; 遍历到第三个的时候, 第三个指向第二个...
            ListNode next = current.next;
            current.next = pre;

            pre = current;
            current = next;

        }
    }

    public static void main(String[] args) {
        ListNode head = ListNode.fromArray(new int[]{1, 2, 3, 4, 5});
        Solution solution = new Solution();
        ListNode res = solution.reverseKGroup(head, 2);
        res.printNode();
    }
}
