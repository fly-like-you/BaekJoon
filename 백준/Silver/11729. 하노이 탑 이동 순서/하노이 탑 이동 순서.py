from collections import deque
n = int(input())

queue = deque()
def hanoi(k, start, end):   # k는 원반의 갯수 n은 이동시킬 탑의 번호

    temp = 6 - (start + end)
    if k == 1:
        count[0] += 1
        queue.append([start, end])
        return

    hanoi(k-1, start, temp)  # 임시공간에 옮기고
    hanoi(1, start, end)  # 목적지에 제일 큰 원반을 두고
    hanoi(k-1, temp, end)  # 임시공간에서 다시 옮기기

count = [0]
hanoi(n, 1, 3)
print(count[0])
while queue:
    x,y = queue.popleft()
    print(f'{x} {y}')