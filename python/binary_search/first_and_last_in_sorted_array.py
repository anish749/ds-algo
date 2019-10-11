"""
Given a sorted array, A, with possibly duplicated elements,
find the indices of the first and last occurrences of a target element, x.
Return -1 if the target is not found.

AirBnB
techseries.dev Oct 10 2019
"""

def get_range(arr, target):
    """
    Returns the indices of the first and last occurrences of a target element in a sorted array.

    The array is sorted, and we are searching for an element.
    This is a variant of binary search.

    :param arr: A sorted array of integers
    :param target: The value being searched for.
    :return: (start, end) The start and end index (0 based). -1 if not found.
    """

    n = len(arr)

    """
    We do two modified binary searches.
    Once to find the first occurrence.
        In this search, we have an extra condition for the high
    Second to find the last.
        In this search, we have an extra condition for the low
    """

    # First search to find the first occurrence
    low = 0
    high = n -1
    mid = -1  # Initialized. This value is not used.
    found = False  # Flag

    while low <= high:
        mid = (low + high) // 2
        if arr[mid] < target or arr[mid] < target:
            low = mid + 1
        elif arr[mid] > target:
            high = mid - 1
        elif arr[mid] == target and mid >= 1 and arr[mid - 1] == target:
            high = mid - 1
        elif arr[mid] == target and ((mid >= 1 and arr[mid-1] !=target) or mid == 0):
            found = True
            break


    if not found:
        return -1  # The value doesn't exist

    first = mid

    # Second search to find the last occurrence. We already know the element exists
    low = 0
    high = n - 1

    while low <= high:
        mid = (low + high) // 2
        if arr[mid] < target or arr[mid] < target:
            low = mid + 1
        elif arr[mid] > target:
            high = mid - 1
        elif arr[mid] == target and mid + 1 < n and arr[mid + 1] == target:
            low = mid + 1
        elif arr[mid] == target and ((mid + 1 < n and arr[mid + 1] != target) or mid == n - 1):
            break

    last = mid

    return [first, last]


assert get_range([1, 2, 3, 4, 5], 3) == [2, 2]
assert get_range([0, 1, 2, 3, 4, 5], 3) == [3, 3]
assert get_range([1, 2, 3, 3, 3, 4, 5], 3) == [2, 4]
assert get_range([0, 1, 2, 3, 3, 4, 5], 3) == [3, 4]
assert get_range([1, 2, 3, 4, 5, 5, 5, 5], 5) == [4, 7]
assert get_range([0, 0, 1, 2, 3, 3, 4, 5], 0) == [0, 1]
assert get_range([], 3) == -1
assert get_range([1, 2, 4, 5, 6], 3) == -1
assert get_range([-99, 0], 3) == -1
