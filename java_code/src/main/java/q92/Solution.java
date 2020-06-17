package q92;

import utils.ListNode;

/*
92. 反转链表 II
反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

说明:
1 ≤ m ≤ n ≤ 链表长度。

示例:

输入: 1->2->3->4->5->NULL, m = 2, n = 4
输出: 1->4->3->2->5->NULL
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode current = head;
        ListNode pre = null;
        int index = 1;

        ListNode firstNode = head;
        ListNode firstNodePre = null;

        while (current != null) {
            ListNode next =  current.next;
            if (index == m) {
                firstNode = current;
                firstNodePre = pre;
            } else if(index > m && index < n) {
                current.next = pre;
            } else if(index == n) {
                if (firstNodePre != null) {
                    firstNodePre.next = current;
                }
                firstNode.next = next;
                current.next = pre;
                if (m == 1) {
                    head = current;
                }
            }
            pre = current;
            current = next;
            index ++;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode listNode = ListNode.fromArray(new int[]{1, 2, 3, 4, 5});
        int m = 2;
        int n = 4;
        ListNode res = s.reverseBetween(listNode, 2, 4);
        res.printNode();
    }
}
