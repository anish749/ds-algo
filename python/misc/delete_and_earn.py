# https://leetcode.com/problems/delete-and-earn/submissions/

from collections import Counter
from typing import List

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        freq = Counter(nums)
        
        value_by_num = { k : k * f for k, f in freq.items() }
        

        # now this is a knapsack problem
        # we need to find the max value that can be obtained by taking the items
        sums = [0] * (10**4 + 1)
        

        for i in range(1, 10**4+1):
            
            if i < 2:
                sums[i]= value_by_num.get(i, 0)
            else:
                if value_by_num.get(i, 0) > 0:
                    sums[i]= max(
                        # i is chosen
                        value_by_num.get(i, 0) + sums[i-2],

                        # i is not chosen
                        sums[i-1]
                    )
                else:
                    sums[i] = sums[i-1]
        
        return max(sums)

total = Solution().deleteAndEarn([8,3,4,7,6,6,9,2,5,8,2,4,9,5,9,1,5,7,1,4])
assert total == 61
print(total)
total = Solution().deleteAndEarn([1,1,1,2,4,5,5,5,6])
assert total == 18
print(total)

assert Solution().deleteAndEarn([1]) == 1
assert Solution().deleteAndEarn([]) == 0

assert Solution().deleteAndEarn([1,6,3,3,8,4,8,10,1,3]) == 43