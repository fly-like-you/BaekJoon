import sys
n=int(sys.stdin.readline())
arr=list(map(int,sys.stdin.readline().split()))
sort_arr=sorted(set(arr))
for i in range(n):
    target = arr[i]
    length = len(sort_arr)
    left = 0
    right = length-1

    while left<right:
        mid = (left+right)//2
        if sort_arr[mid] < target:
            left=mid+1
        else:
            right=mid
    print(left,end=" ")