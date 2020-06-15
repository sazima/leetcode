package q24;

import utils.ListNode;

/*
给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

 

示例:

给定 1->2->3->4, 你应该返回 2->1->4->3.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    // 执行用时 :
    //0 ms
    //, 在所有 Java 提交中击败了
    //100.00%
    //的用户
    public ListNode swapPairs(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode first = head;  // 交换时的第一个
        ListNode second = first.next;
        ListNode newHead = first.next;

        while (true) {
            if (null == first) {
                break;
            }
            second = first.next;
            if (null == second) {
                // 最后就剩一个
                break;
            }
            ListNode afterSecond = second.next;
            // second指向first, first指向second.next.next(或second.next) ; 完成后执行下一次交换
            if (afterSecond == null) {
                first.next = null;
            } else {
                if (afterSecond.next == null) {
                    // 到头了
                    first.next = afterSecond;
                } else {
                    first.next = afterSecond.next;
                }
            }
//            first.next = afterSecond != null ? afterSecond.next : null;
            second.next = first;

            first  = afterSecond;
        }
        return newHead;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode a = ListNode.fromArray(new int[]{1, 2, 3, 4, 5});
        ListNode res = s.swapPairs(a);
        System.out.println("done");
        res.printNode();
    }
}
