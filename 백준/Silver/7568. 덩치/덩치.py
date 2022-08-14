num = int(input())
memberBodyInfo = []
ranking = []

for i in range(num):
    weightHeight = list(map(int, input().split()))
    memberBodyInfo.append(weightHeight)
for i in memberBodyInfo:
    rank = 1
    for j in memberBodyInfo:
        if i[0] < j[0] and i[1] < j[1]:
            rank += 1
    print(rank, end=' ')
