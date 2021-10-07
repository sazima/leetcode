"""
将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例 1：
输入：l1 = [1,2,4], l2 = [1,3,4]
输出：[1,1,2,3,4,4]

示例 2：
输入：l1 = [], l2 = []
输出：[]

示例 3：
输入：l1 = [], l2 = [0]
输出：[0]

提示：
两个链表的节点数目范围是 [0, 50]
-100 <= Node.val <= 100
l1 和 l2 均按 非递减顺序 排列


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        current_l1 = l1
        current_l2 = l2
        new_current = ListNode()
        result =  new_current

        while True:
            if current_l2 is None or current_l1 is None:
                if current_l2:
                    new_current.next = current_l2
                    break
                elif current_l1:
                    new_current.next = current_l1
                    break
                else:
                    break
            if current_l1.val > current_l2.val:
                new_current.next = current_l2
                current_l2 = current_l2.next
            else:
                new_current.next = current_l1
                current_l1 = current_l1.next
            new_current = new_current.next

        return result.next