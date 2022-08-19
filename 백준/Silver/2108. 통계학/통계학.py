from collections import Counter
import sys

N = int(input())
numList = []
for i in range(N):
    num = int(sys.stdin.readline().rstrip())
    numList.append(num)

numList.sort()
nums = Counter(numList).most_common()
print(round(sum(numList) / N))
print(numList[(N) // 2])
if len(nums) > 1:
    if nums[0][1] == nums[1][1]:
        print(nums[1][0])
    else:
        print(nums[0][0])
else:
    print(nums[0][0])
print(numList[-1] - numList[0])
