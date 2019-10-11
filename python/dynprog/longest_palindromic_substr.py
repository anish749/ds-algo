"""
Longest Palindromic substring.

Given a string, find the longest palindromic substring on that string.

Twitter,
techseries.dev - 8th Oct.
"""



def longestPalindromicSubstr(s):
    """
    Algorithm:
        Start with two iterable variables:
            i - iterates from 0 to n/2
            j - iterates from n-1 to n/2+1
        If the s[i]==s[j], recur to check if s[i-1]==s[j-1]
        else find the longest palindrome in s[i+1, j] and s[i, j-1]
          (i and j are both 0 based indexed in the last line)

        This algorithm sort of works, but would be slow ( worst case - O(2^n) )

        However from this algorithm, we see that we need one function.
            y = f(i, j)
        where `i` and `j` are the indexes that create a substring from s, and
        `y` is a boolean indicating if the string is a palindrome or not.

        For a general case we have a function that takes two independent variables
        and produces one value as output. This is also evident from the fact that
        the recursive solution involves two recursive calls, hence O(2^n) worst
        case time complexity.

        This leads us to having a 2D array as a memoization table.

        Thinking in DP / memoization:
            Remember the recursive approach was:
            "If the s[i]==s[j], recur to check if s[i-1]==s[j-1]"
            The reverse of this is given s[i][j] is known to be a palindrome,
            if s[i+1] == s[j+1] then i to j is a palindrome.
            The reverse is the memoization approach.

            Note We want to memoize the function: y = f(i, j)

            i is 0 to n-1
            j is 0 to n-1
        The solution to the above is basically making an attempt to create a
        lookup table for all values of i and j.

        We now attempt to write the recursive function by using the mem table.
        or defining a relationship in this mem table, so that we can
        use a known cell instead of calculating from scratch.

        f(0, 0) = True  # One character string. (this looks like the base case)
        f(1, 1) = True  # One character string.

        f(0, 1) = s[0] == s[1] # 2 character string.

        Here is another trick, the base case for this function is all 1 character
        and 2 character strings. Since this information can't be derived from
        anything else.
        Next for 3 (to n) character string, we can derive this information
        from the 1 char string by making 1 comparison.

    :param s: Input String
    :return: The longest palindromic substring.
    """
    n = len(s)
    longest_palindrome = (0, 0) # Starting at index 0 and ending at index 0

    mem = [ [False for i in range(n)] for j in range(n) ]  # Initialize

    # All 1 character strings
    for i in range(n):
        mem[i][i] = True

    # For 2 character strings
    i = 0
    while i < n - 1:
        mem[i][i+1] = s[i] == s[i+1]
        if mem[i][i+1]:
            longest_palindrome = (i, i+1)
        i += 1

    # For 3 and more
    l = 3
    while l <= n:
        i = 0
        while i <= n - l:
            j = i + l -1 # The substr is (i, j)
            mem[i][j] = s[i] == s[j] and mem[i+1][j-1]
            if mem[i][j]:
                longest_palindrome = (i, j)
            i += 1
        l += 1


    if n <= 1:
        return s
    else:
        return s[longest_palindrome[0]: longest_palindrome[1]+1]


# Test program
assert longestPalindromicSubstr("tracecars") == "racecar"
assert longestPalindromicSubstr("racecars") == "racecar"
assert longestPalindromicSubstr("tracecar") == "racecar"
assert longestPalindromicSubstr("") == ""
assert longestPalindromicSubstr("a") == "a"
assert longestPalindromicSubstr("assa") == "assa"
