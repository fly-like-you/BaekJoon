import sys
input = sys.stdin.readline
N = int(input())
target = sorted(list(map(int, input().split())))

M = int(input())
cards = list(map(int, input().split()))
answer = []

# nlogn
def binary_search(array, target, start, end):
    if start > end:
        return False
    mid = (start + end) // 2

    # 원하는 값 찾은 경우 인덱스 반환
    if array[mid] == target:
        return True
    # 원하는 값이 중간점의 값보다 작은 경우 왼쪽 부분(절반의 왼쪽 부분) 확인
    elif array[mid] > target:
        return binary_search(array, target, start, mid - 1)
    # 원하는 값이 중간점의 값보다 큰 경우 오른쪽 부분(절반의 오른쪽 부분) 확인
    else:
        return binary_search(array, target, mid + 1, end)


for card in cards:
    if binary_search(target, card, 0, N-1):
        answer.append(1)
    else:
        answer.append(0)


for i in range(M):
    if i == M - 1:
        print(answer[i])
    else:
        print(answer[i], end=' ')