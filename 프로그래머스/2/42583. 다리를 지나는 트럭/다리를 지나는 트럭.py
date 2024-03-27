from collections import deque

def solution(bridge_length, weight, truck_weights):
    bridge = deque([0 for _ in range(bridge_length)])
    truck_weights = deque(truck_weights)
    answer = 0
    balance = sum(bridge)
    while truck_weights:
        balance -= bridge.popleft()

        if balance + truck_weights[0] <= weight:
            a = truck_weights.popleft()
            bridge.append(a)
            balance += a
        else:
            bridge.append(0)
        answer += 1

    return answer + bridge_length