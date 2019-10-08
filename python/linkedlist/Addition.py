"""
You are given two linked-lists representing two non-negative integers.
The digits are stored in reverse order and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.

Example:
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

Microsoft,
techseries.dev - Oct 6th 2019
"""


# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class LinkedListAddition:
    """
    Actual code to add two numbers stored as reverse linked lists.
    Returns a new linked list.
    """

    def addTwoNumbers(self, l1, l2, c=0):
        if l1 and l2:
            v = l1.val + l2.val + c
            n = ListNode(v % 10)
            others = self.addTwoNumbers(l1.next, l2.next, v // 10)
            n.next = others
            return n
        elif l1 or l2:
            z = ListNode(0)
            return self.addTwoNumbers(l1 or z, l2 or z, c)
        elif c != 0:
            return ListNode(c)
        else:
            return None

def to_string(result):
    """
    Utility to convert to string
    """
    s = ""
    while result:
        s = str(result.val) + " " + s
        result = result.next
    return s


def to_int(l):
    """
    Utility to test
    """
    return int(to_string(l).replace(" ", ""))


# Test cases

# Vanilla test case.
l1 = ListNode(2)
l1.next = ListNode(4)
l1.next.next = ListNode(3)

l2 = ListNode(5)
l2.next = ListNode(6)
l2.next.next = ListNode(4)

result = LinkedListAddition().addTwoNumbers(l1, l2)
assert to_int(l1) + to_int(l2) == to_int(result)  # 8 0 7

# Add with variable lengths,
# Also test by swapping l1 and l2

# 42
l1 = ListNode(2)
l1.next = ListNode(4)

# 7465
l2 = ListNode(5)
l2.next = ListNode(6)
l2.next.next = ListNode(4)
l2.next.next.next = ListNode(7)

result = LinkedListAddition().addTwoNumbers(l1, l2)
assert to_int(l1) + to_int(l2) == to_int(result)  # 7 5 0 7

result = LinkedListAddition().addTwoNumbers(l2, l1)
assert to_int(l1) + to_int(l2) == to_int(result)  # 7 5 0 7

# Carry forward that increases the length of the list.
l1 = ListNode(9)
l2 = l1
result = LinkedListAddition().addTwoNumbers(l1, l2)
assert to_int(l1) + to_int(l2) == to_int(result)  # 1 8
