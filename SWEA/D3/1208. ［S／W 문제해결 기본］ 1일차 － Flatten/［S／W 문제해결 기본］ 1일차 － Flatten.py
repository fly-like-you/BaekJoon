


def solution(dump, boxes):
    top = max(boxes)
    dump2 = dump
    H = 100
    for h in range(1, H+1):
        
        for i in range(100):
            if dump == 0:
                break
            
            if boxes[i] <= h:
                dump -= 1
                boxes[i] += 1
                
    for h in range(top, 1, -1):            
        for i in range(100):
            if dump2 == 0 :
                break
                
            if boxes[i] >= h:
                dump2 -= 1
                boxes[i] -= 1
    return max(boxes) - min(boxes)
            
T = 10
for t in range(1, T+1):
    dump = int(input())
    boxes = list(map(int, input().split()))
    print(f'#{t} {solution(dump, boxes)}')
