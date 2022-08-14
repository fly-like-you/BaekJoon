import sys
num = int(input())
stack = []
for i in range(num):
    value = int(sys.stdin.readline().rstrip())
    if value != 0:
        stack.append(value)
    else:
        stack.pop()

print(sum(stack))