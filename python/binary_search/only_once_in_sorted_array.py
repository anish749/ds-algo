"""
Find the element that appears once in a sorted array, where all others appear twice.

Given a sorted array in which all elements appear twice (one after one)
and one element appears only once. Find that element in O(log n) complexity.

"""

"""
A variant of the non_duplicate_element problem in lists where the list is sorted.

Sorted = the strongest hint for an application of binary search.

Now a binary search requires that we have a target element that we are searching.
Here we don't have anything.

However can we partition the array into two and be certain that the element doesn't
exist in one part of the array?
This is possible because if an element is present twice, and it is on the right side
if the mid value is even and arr[mid] = arr[mid+1].
"""

def only_once_in_sorted_array(arr: list) -> int:
    n = len(arr)
    if n == 0:
        return None  # Edge case with no elements, is that valid?
    low = 0
    high = n

    while low <= high:
        mid = (low + high ) // 2
        if mid % 2 == 0:
            if mid + 1 < n and arr[mid] == arr[mid + 1]:
                low = mid + 1
            elif mid > 0 and arr[mid] == arr[mid - 1]:
                high = mid - 1
            else:
                return arr[mid]
        if mid % 2 != 0:
            if mid > 0 and arr[mid] == arr[mid - 1]:
                low = mid + 1
            elif mid + 1 < n and arr[mid] == arr[mid + 1]:
                high = mid - 1
            else:
                return arr[mid]


# Tests
tests = [
    ([1, 1, 2], 2),
    ([], None),
    ([1], 1),
    ([2, 2, 3, 3, 4, 4, 6], 6),
    ([2, 2, 3, 4, 4, 6, 6], 3),
    ([0, 2, 2, 3, 3, 4, 4, 6, 6], 0),
]

for (arr, expected) in tests:
    assert only_once_in_sorted_array(arr) == expected
