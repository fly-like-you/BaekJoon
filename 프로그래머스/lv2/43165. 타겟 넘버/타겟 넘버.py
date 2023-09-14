from collections import deque

answer = 0
def solution(numbers, target):
    dfs(numbers, 0, target, 0)
    return answer


def dfs(start, index, target, now):
    global answer
    if index == len(start):
        if target == now:
            answer += 1
        return

    for i in (start[index], start[index] * -1):
        if index < len(start):
            dfs(start, index + 1, target, now + i)
            
        
