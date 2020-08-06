package q148;

import utils.ListNode;

/*
148. 排序链表
在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。

示例 1:

输入: 4->2->1->3
输出: 1->2->3->4
示例 2:

输入: -1->5->3->4->0
输出: -1->0->3->4->5
 */
public class Solution {
    // 分治法  3ms 99%
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode slowNext = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(slowNext);

        ListNode current = new ListNode(0);
        ListNode newHeader = current;
        while (left != null && right != null) {
            if (left.val < right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }
        current.next = left != null ? left : right;
        return newHeader.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.sortList(null);
    }
}
