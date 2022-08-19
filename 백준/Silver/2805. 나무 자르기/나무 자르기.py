import sys
import math

def findMeter(list, now):
    meter = 0
    for i in list:
        if i > now:
            meter += i - now
    return meter


def binarySearch2(target,list, start, end):

    while start <= end:
        mid = (start + end) // 2
        if findMeter(list, mid) == target:
            return mid
        elif findMeter(list, mid) < target:
            end = mid - 1
        elif findMeter(list, mid) > target:
            start = mid + 1
    return end


N, targetMeter = map(int, input().split())
treeList = list(map(int, sys.stdin.readline().rstrip().split()))
maxTree = max(treeList)
maxHeight = maxTree - math.ceil(targetMeter / N)
minHeight = maxTree - targetMeter

nowHeight = binarySearch2(targetMeter, treeList, minHeight, maxHeight)
print(nowHeight)

