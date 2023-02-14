# 1. 최소
def solution(sizes):
    small_list = [ min(i) for i in sizes]
    large_list = [ max(i) for i in sizes]
    
    return max(small_list) * max(large_list)
        
    
            