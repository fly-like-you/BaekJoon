
N = int(input())

squareList = [i ** 2 for i in range(1, int(N**(1/2))+1)]

dp = [0, 1, 2, 3, 1, 2, 3, 4]  # 7까지 최솟값을 받아옴
for i in range(8, N+1):
    for j in range(len(squareList)):
        if squareList[j] >= i:
            break

    minValue = dp[i-1] + 1
    for k in range(j , 0, -1):
        minValue = min(minValue, dp[i-squareList[k]] + 1)


    dp.append(minValue)

print(dp[N])
