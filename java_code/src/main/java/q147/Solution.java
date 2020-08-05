package q147;

import utils.ListNode;

/*
147. 对链表进行插入排序。


插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。

 

插入排序算法：

插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
重复直到所有输入数据插入完为止。
 

示例 1：

输入: 4->2->1->3
输出: 1->2->3->4
示例 2：

输入: -1->5->3->4->0
输出: -1->0->3->4->5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/insertion-sort-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    // 4ms 60%
    public ListNode insertionSortList(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode current = head;
        ListNode first = head;
        ListNode previous = null;

        while (current != null) {
            if (previous == null || previous.val <= current.val) {
                previous = current;
                current = current.next;
                continue;
            }
            ListNode left = first;
            ListNode currentNext = current.next;
            while (left != current) {
                ListNode temp0 = left.next;
                if (left == first && current.val <= left.val) {
                    previous.next = currentNext.next;
                    first = current;
                    current.next = left;
                    break;
                }
                if (current.val >= left.val && current.val < left.next.val) {
                    current.next = temp0;
                    left.next = current;
                    previous.next = currentNext;
                    break;
                }
                left = temp0;
            }
            current = currentNext;
        }
        return first;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode r1 = new ListNode(-1);
        ListNode r2 = new ListNode(5);
        ListNode r3 = new ListNode(3);
        ListNode r4 = new ListNode(4);
        ListNode r5 = new ListNode(0);
        r1.next = r2;
        r2.next = r3;
        r3.next = r4;
        r4.next = r5;
//        ListNode r1 = new ListNode(-1);
//        ListNode r1 = new ListNode(-1);


        ListNode res = solution.insertionSortList(r1);
        res.printNode();
    }
}
