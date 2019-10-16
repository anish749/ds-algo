"""
You are given an array of integers in an arbitrary order.
Return whether or not it is possible to make the array non-decreasing
by modifying at most 1 element to any value.

We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).

Example:

[13, 4, 7] should return true, since we can modify 13 to any value 4 or less, to make it non-decreasing.

[13, 4, 1] however, should return false, since there is no way to modify just one element to make the array non-decreasing.

Can you find a solution in O(n) time?

Microsoft,
techseries.dev Oct 15, 2019
"""


def non_decreasing_with_one_mod(arr: list) -> bool:
    """
    The array is very close to being sorted, except for one element.

    We traverse the array to find out if there exists only one such number.

    Time  - O(n)
    Space - O(1)
    """
    c = 0  # Number of elements which are more than the element after it.
    for i in range(len(arr) - 1):  # When we need to access i and i+1 element.
        if not arr[i] <= arr[i + 1]:
            c = c + 1

    # Note the base case of the problem is when the length of the array is 2 or less
    # Because c is initialized to 0, c <= 1 evaluates to true, and this is always possible.
    return c <= 1


# Tests
assert non_decreasing_with_one_mod([13, 4, 7])
assert non_decreasing_with_one_mod([5,1,3,2,5]) == False
assert non_decreasing_with_one_mod([13, 4])
assert non_decreasing_with_one_mod([-3, 4])
assert non_decreasing_with_one_mod([-3, -20, -10])
assert non_decreasing_with_one_mod([1])
assert non_decreasing_with_one_mod([])
assert non_decreasing_with_one_mod([5,1,3,-7,5]) == False
