import sys
n = int(input())
l1 = []
for i in range(n):
    l1.append(int(sys.stdin.readline().rstrip()))
l1.sort()
for i in l1:
    print(i)