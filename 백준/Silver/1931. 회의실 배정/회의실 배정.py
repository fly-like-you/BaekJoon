import sys
N = int(sys.stdin.readline())
conference = []
max = 0
count = 0
for _ in range(N):
    conference.append(list(map(int, sys.stdin.readline().split())))

conference.sort(key=lambda x:x[0])
conference.sort(key=lambda x:x[1])
# 가장 빠르게 끝나는 회의를 선택
# 이 때, 회의 시간이 같은 경우 늦게 시작하는 강의를 선택
last = 0
count = 0
for i,j in conference:
    if i >= last:
        count += 1
        last = j


print(count)