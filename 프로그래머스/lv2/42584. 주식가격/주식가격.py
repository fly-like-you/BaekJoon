
def solution(prices):
    answer = [0 for _ in range(len(prices))] # 가격이 내려가지 않은 시간
    stack = [] # 경과된 시간이 담기는 스택
    # 3, 4, 4, 2
    for i, price in enumerate(prices):
        while stack and price < prices[stack[-1]]: # 현재 가격과 스택에 담긴 가격을 최신순으로비교함
            # 가격이 내려갔으면 answer에 얼마나 안내려간지 적어줘야함
            j = stack.pop() # 시간
            answer[j] = i - j
        stack.append(i)
    
    # 위의 반복문이 끝나면 가격이 내려간 것들에 대해서만 쌓을것
    while stack:
        j = stack.pop()
        answer[j] = len(prices) - 1 - j
        
    return answer
            