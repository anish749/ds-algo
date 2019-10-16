"""
Given an integer k and a binary search tree, find the floor (less than or equal to) of k,
and the ceiling (larger than or equal to) of k.
If either does not exist, then print them as None.

Apple,
techseries.dev Oct 16th 2019.
"""


class Node:
    def __init__(self, value):
        self.left = None
        self.right = None
        self.value = value


def find_ceiling_floor(root_node: Node, k, floor=None, ceil=None) -> (int, int):
    if not root_node:
        return floor, ceil
    if k > root_node.value:
        return find_ceiling_floor(root_node.right, k, root_node.value, ceil)
    elif k < root_node.value:
        return find_ceiling_floor(root_node.left, k, floor, root_node.value)
    else: # == k
        return k, k



root = Node(8)
root.left = Node(4)
root.right = Node(12)

root.left.left = Node(2)
root.left.right = Node(6)

root.right.left = Node(10)
root.right.right = Node(14)

assert find_ceiling_floor(root, 5) == (4, 6)
assert find_ceiling_floor(root, 4) == (4, 4)  # an inner node
assert find_ceiling_floor(root, 8) == (8, 8)  # root itself
assert find_ceiling_floor(root, 2) == (2, 2)  # left leaf node
assert find_ceiling_floor(root, 14) == (14, 14)  # right leaf node
assert find_ceiling_floor(root, 11) == (10, 12)
assert find_ceiling_floor(None, 5) == (None, None)
assert find_ceiling_floor(Node(1), 5) == (1, None)
