# 한번 끝까지 올라가면 내림차순만 가능하다!

N = int(input())
stack = []
now = 1
order = []
find = True
for i in range(N):
    num = int(input()) # 3
    while now <= num:
        stack.append(now)
        order.append("+")
        now += 1
    if stack[-1] == num:
        stack.pop()
        order.append('-')
    else:
        find = False

if not find:
    print("NO")
else:
    print('\n'.join(order))