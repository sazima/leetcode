package q143;

import utils.ListNode;

import java.util.HashMap;

/*
143. 重排链表
给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

示例 1:

给定链表 1->2->3->4, 重新排列为 1->4->2->3.
示例 2:

给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reorder-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    // 6ms 待优化
    public void reorderList(ListNode head) {
        ListNode node = head;
        HashMap<Integer, ListNode> indexNodeMap = new HashMap<>();
        int i = 0;
        while (true) {
            if (null == node) {
                i--;
                break;
            }
            indexNodeMap.put(i, node);
            node = node.next;
            i++;
        }

        int l = 0;
        int r = i;
        ListNode previous = new ListNode(0);
        while (l <= r) {
            ListNode left = indexNodeMap.get(l);
            if (l == r) {
                left.next = null;
                previous.next = left;
                break;

            } else {
                ListNode right = indexNodeMap.get(r);
                previous.next = left;
                left.next = right;
                right.next = null;
                previous = right;
                l++;
                r--;
            }

        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        Solution solution = new Solution();
        solution.reorderList(l1);

    }
}
