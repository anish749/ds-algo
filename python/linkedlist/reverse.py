"""
Given a singly-linked list, reverse the list.
This can be done iteratively or recursively.

Can you get both solutions?

Google,
techseries.dev Oct 11, 2019
"""


class ListNode(object):
    """
    Our awesome List Node
    """
    def __init__(self, x):
        self.val = x
        self.next = None

    # Function to show a string representation
    def __str__(self):
        node = self
        output = ""
        while node is not None:
            output += str(node.val)
            output += " -> "
            node = node.next
        output += "NIL"
        return output


def create_linked_list(arr: list) -> ListNode:
    """
    Helper to create a linked list.
    """
    root = None
    curr = None
    for e in arr:
        if curr:
            n = ListNode(e)
            curr.next = n
            curr = curr.next
        else:  # Initial value
            root = ListNode(e)
            curr = root

    return root



def reverse_recursive(root: ListNode) -> ListNode:
    # base case
    if root.next is None:
        return root

    pass

def reverse_iterative(root: ListNode) -> ListNode:
    print(root)

    cur = root
    prev = None
    while cur.next:
        if prev:
            cur.next = prev
            prev = cur
        else:  # head element
            prev = cur
            prev.next = None

    print(cur)

    return cur



# Tests
from typing import Callable  # Type of a higher order function
def test(impl: Callable[[ListNode], ListNode], arr: list) -> None:
    expected = create_linked_list(arr[-1:])
    assert impl(create_linked_list(arr)) == expected


test(reverse_iterative, [1, 2, 3, 4])