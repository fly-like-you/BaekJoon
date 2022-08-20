import sys

N, M = map(int,input().split())
passInfo = {}
for i in range(N):
    name, pw = sys.stdin.readline().rstrip().split()
    passInfo[name] = pw

for i in range(M):
    q = sys.stdin.readline().rstrip()
    print(passInfo[q])
