# https://leetcode.com/problems/find-substring-with-given-hash-value/


def subStrHash(s: str, power: int, modulo: int, k: int, hashValue: int) -> str:
    def val(c):
        return ord(c) - 96

    running = 0
    p = 1
    for i in range(k):
        running += val(s[i]) * (power**i)
        # running %= modulo
        p *= power

    if int(running % modulo) == hashValue:
        return s[:k]

    for i in range(k, len(s)):
        running -= val(s[i - k])
        running /= power
        # running %= modulo

        running += val(s[i]) * p
        # running %= modulo

        print(i, running, int(running % modulo))
        if int(running % modulo) == hashValue:
            return s[i - k + 1 : i + 1]


assert (
    subStrHash(
        "cbmzzngpnfyzoexfnzxhhyvzxibaijgfvaleowaqjllkgoercyiptkugzgcxobn",
        83,
        56,
        27,
        23,
    )
    == "hyvzxibaijgfvaleowaqjllkgoe"
)


assert subStrHash("xxterzixjqrghqyeketqeynekvqhc", 15, 94, 4, 16) == "nekv"

assert subStrHash("leetcode", 7, 20, 2, 0) == "ee"
assert subStrHash("fbxzaad", 31, 100, 3, 32) == "fbx"
