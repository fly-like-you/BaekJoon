from itertools import permutations
import math
def solution(numbers):
    num_list = list(numbers)
    
    candidates = set()
    for i in range(1, len(num_list) + 1):
        for item in list(permutations(num_list, i)):
            candidates.add(int(''.join(item)))
    answer = 0
    for prime in candidates:
        if prime == 1 or prime == 0:
            continue
        if is_prime_number(prime):
            answer += 1
    return answer

def is_prime_number(x):
    # 2부터 x의 제곱근까지의 모든 수를 확인하며
    for i in range(2, int(math.sqrt(x)) + 1):
        # x가 해당 수로 나누어떨어진다면
        if x % i == 0:
            return False # 소수가 아니다.
    return True
