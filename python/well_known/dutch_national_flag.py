"""
Given a list of numbers with only 3 unique numbers (1, 2, 3), sort the list in O(n) time.

Challenge: Try sorting the list using constant space.

Google, Accolite.
techseries.dev 12th Oct, 2019
"""

"""
We know we have to sort in O(n) time which is possible only because the number of
unique elements in our input list is 3.
There is something special about 3!!

Simple approach:
Count the number of times each element appears. You spent O(n) time
and sort the 3 numbers O (3 log 3) ~ near constant.
Then create a new list repeating the number as many times they occur.
Space complexity, O(n) - You are creating a new list.

The real challenge:
This problem comes as a variant of quick sort.
Quick Sort involves finding a pivot element and "partitioning"
the array into two parts, things less than the pivot, and things
more than the pivot. However this problem requires a 3-way
partitioning. >, =, < when compared to a pivot element.

This problem is primarily aimed to go deeper into partitioning.
Also note that this works for mutable data structures only.
It mutates the input array.

Because we know that we have 3 unique elements, it is we can fi
"""

def swap(arr: list, a: int, b: int) -> None:
    t = arr[a]
    arr[a] = arr[b]
    arr[b] = t
    print(arr)

def dutch_national_flag_sort(arr: list) -> None:
    start = 0
    n = len(arr)
    pivot = start  # Constant O(1) space complexity

    # We work with 2 passes, since we need to effectively partition
    # this array twice.

    # Step 1.
    # Find all elements less than pivot and make sure they are left
    # of the pivot.
    for i in range(start + 1, n):
        if pivot < n and arr[i] < arr[pivot]:
            swap(arr, i, pivot)
            pivot = pivot + 1
    print("2")
    # Step 2
    # Scan the element from the right, and make sure everything greater
    # than the p is also sorted correctly
    pivot = n - 1
    for i in range(n - 2, start - 1, -1):
        if pivot >= 0 and arr[i] > arr[pivot]:
            swap(arr, i, pivot)
            pivot = pivot - 1


# Tests
import random
num_tests = 100
for x in range(1):
    arr_len = random.randint(0, 10)
    arr = [random.randint(0, 2) for y in range(arr_len)]
    arr = [0, 2, 1, 2, 1, 0]
    print(arr)
    expected = sorted(arr)

    dutch_national_flag_sort(arr)
    if arr != expected:
        print("Expected", expected)
        print("actual", arr)
    assert arr == expected

e = []
dutch_national_flag_sort([])
assert e == []
e = [0]
dutch_national_flag_sort([])
assert e == [0]