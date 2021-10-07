"""
24. 两两交换链表中的节点
给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。



示例 1：


输入：head = [1,2,3,4]
输出：[2,1,4,3]
示例 2：

输入：head = []
输出：[]
示例 3：

输入：head = [1]
输出：[1]
"""
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next  # type: 'ListNode'


class Solution:

    def swapPairs(self, head: ListNode) -> ListNode:
        if not head or head.next is None:
            return head
        new_node = ListNode()
        new_node.next = head
        current_header = new_node
        while True:
            if current_header is None:
                break
            if current_header.next is None:
                break
            next_ = current_header.next
            next_next = next_.next

            if next_next is None:
                next_next_next = None
                current_header.next = next_
                current_header = None
            else:
                next_next_next = next_next.next
                current_header.next = next_.next
                current_header.next.next = next_
                next_.next = next_next_next
                current_header = next_next.next

        return new_node.next
            # current_header.next = None

if __name__ == '__main__':
    # [1,2,3,4]
    n1 = ListNode(1)
    n2 = ListNode(2)
    n3 = ListNode(3)
    n1.next = n2
    n2.next = n3
    # n3.next = n4
    result = Solution().swapPairs(n1)
    print(result)
