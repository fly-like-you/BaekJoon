import sys
N, K = map(int, sys.stdin.readline().rstrip().split())

expList = list(map(int, sys.stdin.readline().rstrip().split()))
sortExpList = sorted(expList)


exp = 0 # 최초 퀘스트
sortExpList[0] = 0
limit = K
for i in range(1, N): # 클리어 할 퀘스트의 수
    arcaneStone = i
    if i > limit:
        arcaneStone = K
    exp += sortExpList[i] * (arcaneStone)

print(exp)


