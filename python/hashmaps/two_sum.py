"""
You are given a list of numbers, and a target number k. Return whether or not there
are two numbers in the list that add up to k.

Extra: Try to do it in a single pass of the list.

Facebook, Google
techseries.dev, 13th Oct 2019
"""

def two_sum(arr: list, k: int) -> bool:
  """
  This is fairly trivial using two nested loops which compares all pairs,
  and has a time complexity of O(n^2), and a space complexity of O(1).

  An optimization on this is to use a HashMap to store the distinct elements
  of the set and loop and check if (k - arr[i]) exists in the set so that we
  can have arr[x] such that (k - arr[i]) = arr[x] or arr[x] + arr[i] = k

  :param arr: The array or list
  :param k: If two numbers from the array add up to `k`
  :return: Boolean
  """
  hm = set(arr)  # Store unique elements and also provide O(1) contains check.

  for e in arr:
      if k - e in hm:
          return True

  return False


assert two_sum([4,7,1,-3,2], 5)
assert two_sum([5], 5) == False
assert two_sum([5, 0], 5)
assert two_sum([3, 4, 5, 5, 0], 8)
assert two_sum([], 8) == False


def two_sum_one_pass(arr: list, k: int) -> bool:
    """
    The previous solution passes through the given list twice.

    If there are two numbers x and y such that x + y == k,
    in the above algorithm we are checking that twice,
    once for x + y = k and
    again for y + x = k.

    Lets optimize that.
    We start with an empty set, and we add the element e if it
    can't be paired to form k.
    """

    hm = set()
    for e in arr:
        if k - e in hm:
            return True
        else:
            hm.add(e)

    return False

# Tests
assert two_sum_one_pass([4,7,1,-3,2], 5)
assert two_sum_one_pass([5], 5) == False
assert two_sum_one_pass([5, 0], 5)
assert two_sum_one_pass([3, 4, 5, 5, 0], 8)
assert two_sum_one_pass([], 8) == False
