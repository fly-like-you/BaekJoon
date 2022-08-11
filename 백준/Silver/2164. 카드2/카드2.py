from collections import deque
n = int(input())
number = [i for i in range(1,n+1)]
q = deque(number)
while True:
    if len(q) == 1:
        break
    q.popleft()
    q.append(q.popleft())

print(q[0])