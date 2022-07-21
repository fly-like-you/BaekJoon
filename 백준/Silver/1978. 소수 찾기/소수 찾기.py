to = int(input())
numList =  list(map(int, input().split()))

def isPrime(num):
    if num == 1:
        return False
    for i in range(2, num):

        if num % i ==0:
            return False

    return True

count = 0
for i in numList:
    if isPrime(i):
        count += 1
print(count)