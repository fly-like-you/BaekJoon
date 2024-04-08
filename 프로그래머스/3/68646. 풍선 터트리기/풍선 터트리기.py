def solution(a):
    ret = 2
    if 0 <= len(a) <= 2:
        return len(a)
    left = a[0]
    right = a[-1]

    for i in range(1, len(a) - 1):
        if left > a[i]:
            left = a[i]
            ret += 1
        if right > a[-1 - i]:
            right = a[-1 - i]
            ret += 1
        if left == right:
            ret -= 1
            break
            
    
    return ret