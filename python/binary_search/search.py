"""
Binary Search on integers
"""

def bin_search(arr, target):

    n = len(arr)

    low = 0
    high = n -1

    while low <= high:
        mid = (low + high) // 2
        if arr[mid] < target:
            low = mid + 1
        elif arr[mid] > target:
            high = mid - 1
        elif arr[mid] == target:
            return mid

    return -1


assert bin_search([1, 2, 3, 4, 5], 3) == 2
assert bin_search([0, 1, 2, 3, 4, 5], 3) == 3
assert bin_search([], 3) == -1
assert bin_search([1, 2, 4, 5, 6], 3) == -1
assert bin_search([-99, 0], 3) == -1
