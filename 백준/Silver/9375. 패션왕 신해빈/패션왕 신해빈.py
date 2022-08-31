import sys
from collections import Counter


N = int(input())


count = []
for j in range(N):
    M = int(input())
    closet = []
    answer = 1
    for i in range(M):
        wear, type = sys.stdin.readline().rstrip().split()
        closet.append(type)
    a = Counter(closet)
    for key in a:
        answer *= a[key] + 1
    print(answer - 1)

