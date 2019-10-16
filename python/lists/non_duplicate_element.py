"""
Given a list of numbers, where every number shows up twice except for one number,
find that one number.

Challenge: Find a way to do this using O(1) memory.

Facebook,
techseries.dev, Oct 14, 2019
"""


"""
This is a good problem to explain basic understanding of space and time complexities,

See also binary_search/only_once_in_sorted_array.py for an optimization for sorted arrays

Lets start by counting elements in the list. Storing the counts,
and then going over it to find which element occurs once.
Space - O(n) extra space.
Time  - O(n)

Lets optimize space complexity at the cost of time.
Now we can go through each element of the array, and check to see if we can find that
at a different index.
Space - O(1)
Time  - O(n^2) ( For each elements, we try to see if it matches with a different index)

Another algorithm.
Sort the array. (in O(n log n) time and O(n) space), and then find which number doesn't
appear twice.

Optimizing both.
XOR and bit trick.

x ^ x always evaluate to zero. This means if the same number appears an even number of
times, they would cancel each other. Again y ^ 0 is y. So if a number appears odd number
of times, the XOR output would be the number itself.
"""

def only_once_n(arr: list) -> int:
    """
    Lets start by counting elements in the list. Storing the counts,
    and then going over it to find which element occurs once.
    Space - O(n) extra space.
    Time  - O(n)
    """

    from collections import Counter
    counts = Counter(arr)  # Extra space, and constructing this takes O(n) time
    for (k, v) in counts.items():  # Takes O(n) time
        if v == 1:
            return k

    return 0  # For the empty list!!


def only_once_xor_arr(arr: list) -> int:
    """
    Bitwise Math.
    """
    x = 0  # a ^ 0 = 0, hence 0 is the initial value
    for a in arr:
        x = x ^ a
    return x


def only_once_xor_fp(arr: list) -> int:
    """
    Bitwise Math + stylish FP
    """
    from functools import reduce
    return reduce(  # Functional Programming
        lambda a, b: a ^ b,
        arr,
        0  # a ^ 0 = 0, hence 0 is the initial value
    )


# Tests
tests = [
    # List of the input array and the expected output.
    ([1, 1, 2], 2),
    ([], 0),  # Is this a valid case? Shouldn't this output None instead of 0 ?
    ([1], 1),
    ([4, 4, 3, 3, 2, 2, 6], 6),
    ([2, 2, 3, 4, 4, 6, 6], 3),
    ([0, 2, 2, 3, 3, 4, 4, 6, 6], 0),
]

for (arr, expected) in tests:
    assert only_once_n(arr) == expected
    assert only_once_xor_arr(arr) == expected
    assert only_once_xor_fp(arr) == expected
