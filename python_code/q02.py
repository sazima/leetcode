# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:

    # 执行用时：
    # 56 ms
    # , 在所有 Python3 提交中击败了
    # 97.86%
    # 的用户
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        if l1.val == 0 and l1.next is None:
            return l2
        if l2.val == 0 and l2.next is  None:
            return l1
        n1 = 0
        n2 = 0
        numti = 1
        while 1:
            if l1 is None:
                break
            n1 = n1 + l1.val * numti
            l1 = l1.next
            numti *= 10
        numti = 1
        while 1:
            if l2 is None:
                break
            n2 = n2 + l2.val * numti
            numti *= 10
            l2 = l2.next
        result = n1 + n2  # 8 0 7  ----->   7 -> 0 -> 8
        return_result = None
        node = None
        while 1:
            if result == 0:
                break
            g = result % 10
            this_node = ListNode(g)
            if node:
                node.next = this_node
            node = this_node
            if return_result is None:
                return_result = node
            result = result // 10
        return return_result


if __name__ == '__main__':
    n1 = ListNode(2, ListNode(4, ListNode(3)))
    n2 = ListNode(5, ListNode(6, ListNode(4)))
    res = Solution().addTwoNumbers(n1, n2)
    print(res.val)