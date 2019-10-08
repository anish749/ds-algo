"""
Given a string, find the length of the longest substring without repeating characters.

Microsoft,
techseries.dev - Oct 7th 2019
"""


def lengthOfLongestSubstring(s):
    max_count = 0
    counter = 0
    for (i, c) in enumerate(s):
        if i > 0 and c == s[i-1]:
            max_count = max(counter, max_count)
            counter = 1
        else:
            counter += 1

    return max(max_count, counter)  # Check for the last max_count after the iteration




assert lengthOfLongestSubstring('abrkaabcdefghijjxxx') == 10
assert lengthOfLongestSubstring('abrkajxxxabcdefghij') == 11
assert lengthOfLongestSubstring('abcdefghijjabrkajxx') == 10
assert lengthOfLongestSubstring('') == 0
assert lengthOfLongestSubstring('a') == 1

