N = int(input())
array = []
for i in range(N):
    array.append(list(map(int, input().split())))
ans = [0,0,0]


def checksum(row, col, num):
    start = array[row][col]
    for i in range(row, row + num):
        for j in range(col, col + num):
            if start != array[i][j]:
                return False
    return True

def divide(row, col, num):
    if num == 1:
        ans[array[row][col]] += 1
    elif checksum(row, col, num):
        ans[array[row][col]] += 1
    else:
        size = num // 3
        for i in range(3):
            for j in range(3):
                divide(row + size * i, col + size * j, size)

divide(0,0,N)
print(ans[2])
print(ans[0])
print(ans[1])
