def solution(s):
    li = [ int(i) for i in s.split()]
    max_num, min_num = max(li), min(li)
    
    return f"{min_num} {max_num}"