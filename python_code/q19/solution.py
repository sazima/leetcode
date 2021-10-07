"""
 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

进阶：你能尝试使用一趟扫描实现吗？

 

示例 1：


输入：head = [1,2,3,4,5], n = 2
输出：[1,2,3,5]
示例 2：

输入：head = [1], n = 1
输出：[]
示例 3：

输入：head = [1,2], n = 1
输出：[1]
 
提示：
链表中结点的数目为 sz
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
"""

# Definition for singly-linked list.
from typing import List


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        node_list = []  # type: List[ListNode]
        current_node = head
        while current_node is not None:
            node_list.append(current_node)
            current_node = current_node.next
        remove_index = len(node_list) - n
        # remove_node = node_list[remove_index]
        if remove_index == len(node_list) - 1 and len(node_list) > 1:  # 删除倒数第一个
            node_list[remove_index - 1].next = None
            return head
        elif remove_index == 0:  # 删除第零个
            return head.next
        else:
            node_list[remove_index - 1].next = node_list[remove_index + 1]
            return head
