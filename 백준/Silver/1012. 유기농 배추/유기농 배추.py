import sys
sys.setrecursionlimit(10000)
def dfs(x,y):
    if x <= -1 or x >= row or y <= -1 or y >= col:
        return False
    if field[x][y] == 1:
        field[x][y] = 0
        dfs(x-1,y)
        dfs(x,y-1)
        dfs(x+1, y)
        dfs(x,y+1)
        return True
    return False
case = int(input())

for _ in range(case):
    col, row, N = map(int, input().split())
    field = [[0 for i in range(col)] for j in range(row)]
    for i in range(N):
        x,y = map(int, sys.stdin.readline().rstrip().split())
        field[y][x] = 1

    result = 0

    for i in range(row):
        for j in range(col):
            if dfs(i,j) == True:
                result += 1
    print(result)