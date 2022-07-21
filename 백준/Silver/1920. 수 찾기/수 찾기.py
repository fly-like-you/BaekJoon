import sys

n = int(sys.stdin.readline().rstrip())
nList = list(map(int, sys.stdin.readline().split()))
m = int(sys.stdin.readline().rstrip())
mList = list(map(int, sys.stdin.readline().split()))
nList.sort()

def binary_search(list, target,start,end):
    while True:
        if start > end:
            break
        mid = (start + end) // 2
        if list[mid] == target:
            return 1
        elif list[mid] > target:
            end = mid - 1
        else:
            start = mid + 1
    return 0

for i in mList:
    print((binary_search(nList, i, 0, len(nList)-1)))

