# 2
# 5 6
# 0 0 1 0
from itertools import permutations
from collections import deque
from copy import deepcopy

N = int(input())
nums = deque(list(map(int, input().split())))
num_operators = list(map(int, input().split()))
operators = []
for i in range(len(num_operators)):
    if num_operators[i] == 0:
        continue
    elif i == 0:
        for _ in range(num_operators[i]):
            operators.append("+")
    elif i == 1:
        for _ in range(num_operators[i]):
            operators.append("-")
    elif i == 2:
        for _ in range(num_operators[i]):
            operators.append("*")
    elif i == 3:
        for _ in range(num_operators[i]):
            operators.append("/")

operations = list(permutations(operators, len(operators)))

max_val = float('-inf')
min_val = float('inf')
for operation_li in operations:
    operands = deepcopy(nums)
    result = operands.popleft()
    for operation in operation_li:
        num = operands.popleft()
        if operation == "+":
            result += num
        elif operation == "-":
            result -= num
        elif operation == "*":
            result *= num
        elif operation == "/":
            if result < 0 or num < 0:
                result = abs(result) // abs(num) * -1
            else:
                result //= num
    max_val = max(result, max_val)
    min_val = min(result, min_val)

print(max_val)
print(min_val)


