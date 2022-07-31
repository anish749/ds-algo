from collections import defaultdict

def lengthOfLongestSubstringKDistinct(s: str, k: int) -> int:
    
    if k == 0:
        return 0
    
    if k >= len(s):
        return len(s)
    
    start = 0
    end = start + k
    
    count_of_chars = defaultdict(int)
    for i in range(start, end):
        count_of_chars[s[i]] += 1
    
    max_so_far = k
    while end < len(s):
        c = s[end]
        if count_of_chars[c] > 0:
            pass
        elif len(count_of_chars) < k:
            count_of_chars[c] += 1
        else:
            # remove the start and move forward
            while count_of_chars[s[start]] > 0:
                count_of_chars[s[start]] -= 1
                start += 1
            
            count_of_chars[c] += 1

                            
        max_so_far = max(max_so_far, end - start + 1)
        end += 1
        
    return max_so_far
    

assert lengthOfLongestSubstringKDistinct("eceba", 2) == 3
assert lengthOfLongestSubstringKDistinct("aa", 1) == 2
assert lengthOfLongestSubstringKDistinct("aba", 1) == 1
assert lengthOfLongestSubstringKDistinct("aac", 2) == 3
assert lengthOfLongestSubstringKDistinct("abcabcbb", 2) == 3