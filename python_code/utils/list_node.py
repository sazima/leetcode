from typing import List


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

    @classmethod
    def from_list(cls, node_value: List[int]) -> 'ListNode':
        first_node: ListNode = cls(node_value[0])
        node_tail = first_node
        for index, value in enumerate(node_value):
            if index == 0:
                continue
            node_tail.next = ListNode(value)
            node_tail = node_tail.next
        return first_node

    def print(self):
        node = self
        while node is not None:
            print(node.val)
            node = node.next
