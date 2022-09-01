def fib3(n):
    fibTable = [[1,0],[0,1]]
    for i in range(2,n+1):
        fibTable.append([fibTable[i-1][0] + fibTable[i-2][0], fibTable[i-1][1] + fibTable[i-2][1]])
    return fibTable[n]

N = int(input())
for i in range(N):
    case = int(input())
    ans = fib3(case)
    print(ans[0], ans[1])

