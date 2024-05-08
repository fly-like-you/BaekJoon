def solution():
    chk = [1] + [0] * sum(scores)
    for score in scores:
        for i in range(len(chk) - score, -1, -1):
            if chk[i]:
                chk[i+score] = 1
    return sum(chk)



T = int(input())

for t in range(1, T+1):
    N = int(input())
    cnt = 0
    scores = list(map(int, input().split()))

    print(f'#{t} {solution()}')

