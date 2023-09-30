def solution(prices):
    answer = [0] * len(prices)
    for i, price in enumerate(prices):
        for j in range(i + 1, len(prices)):
            if price <= prices[j]:
                answer[i] += 1
            else:
                answer[i] += 1
                break

    return answer