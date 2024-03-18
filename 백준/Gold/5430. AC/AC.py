import sys
input = sys.stdin.readline

def solution(CMD, length, arr):
    r_state = 1
    arr = arr.strip('[]\n').split(',')
    a, b = 0, length
    
    for i in CMD:
        if i == 'R':
            r_state *= -1
        elif i == 'D':
            if r_state == 1:
                a+=1
            elif r_state == -1:
                b-=1
            if a > b:
                return 'error'
    
    if r_state == 1:
        return f'[{",".join(arr[a:b])}]'
    elif r_state == -1:
        if a == 0:
            return f'[{",".join(arr[b-1::-1])}]'
        else:
            return f'[{",".join(arr[b-1:a-1:-1])}]'

T = int(input())
for i in range(T):
    CMD = input()
    length = int(input())
    arr = input()
    print(solution(CMD, length, arr))