
def findEncryptedWord(s):
  # Write your code here
  
  def get_mid_point_idx(s):
    n = len(s)
    if n % 2 == 0:
      return int(n / 2) - 1
    else:
      return int(len(s) / 2)

  if len(s) == 0 or len(s) == 1 or len(s) == 2:
    return s
  
  mid_pt = get_mid_point_idx(s)
  
  left = s[0:mid_pt]
  print(left)
  
  right = s[mid_pt+1:]
  print(right)
  return s[mid_pt] + findEncryptedWord(left) + findEncryptedWord(right)




# These are the tests we use to determine if the solution is correct.
# You can add your own at the bottom.

def printString(string):
  print('[\"', string, '\"]', sep='', end='')

test_case_number = 1

def check(expected, output):
  global test_case_number
  result = False
  if expected == output:
    result = True
  rightTick = '\u2713'
  wrongTick = '\u2717'
  if result:
    print(rightTick, 'Test #', test_case_number, sep='')
  else:
    print(wrongTick, 'Test #', test_case_number, ': Expected ', sep='', end='')
    printString(expected)
    print(' Your output: ', end='')
    printString(output)
    print()
  test_case_number += 1

if __name__ == "__main__":
  s1 = "abc"
  expected_1 = "bac"
  output_1 = findEncryptedWord(s1)
  check(expected_1, output_1)

  s2 = "abcd"
  expected_2 = "bacd"
  output_2 = findEncryptedWord(s2)
  check(expected_2, output_2)

  # Add your own test cases here
  