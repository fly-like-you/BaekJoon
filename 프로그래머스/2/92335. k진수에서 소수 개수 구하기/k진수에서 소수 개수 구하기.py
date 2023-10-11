import math

def solution(n, k):
    answer = 0

    trans_str = trans(n, k)
    primes = trans_str.split('0')
    while '' in primes:
        primes.remove('')
    for prime in primes:
        tar = int(prime)
        answer += is_prime(tar)

    return answer


def is_prime(target):
    if target == 1:
        return 0
    for i in range(2, int(math.sqrt(target)) + 1):
        if target % i == 0:
            return 0
    return 1

def trans(n, k):
    rev_base = ''

    while n > 0:
        n, mod = divmod(n, k)
        rev_base += str(mod)

    return rev_base[::-1]