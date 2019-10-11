"""
Imagine you are building a compiler. Before running any code, the compiler must check that the parentheses in the program are balanced. Every opening bracket must have a corresponding closing bracket. We can approximate this using strings.

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
- Open brackets are closed by the same type of brackets.
- Open brackets are closed in the correct order.
- Note that an empty string is also considered valid.

Uber, Facebook,
techseries.dev Oct 09 2019
"""

def balanced_paranthesis(s):
    """
    Check if the string contains balanced parenthesis

    We use a stack to make sure brackets are closed in the correct order.

    :param s: string
    :return: boolean
    """

    st = []
    for c in s:
        if c in {'(', '{', '['}:
            st.append(c)  # O(1)
        elif c == ')':
            if not st.pop() == '(':
                return False
        elif c == '}':
            if not st.pop() == '{':
                return False
        elif c == ']':
            if not st.pop() == '[':
                return False

    return len(st) == 0


# Test cases
assert balanced_paranthesis("")
assert balanced_paranthesis("[()]{}")
assert balanced_paranthesis("((()))")
assert balanced_paranthesis("((()|()))")
assert balanced_paranthesis("({[)]") == False
assert balanced_paranthesis("absd")
assert balanced_paranthesis("((()))[") == False