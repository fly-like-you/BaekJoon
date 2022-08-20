import sys

N,M = map(int, sys.stdin.readline().rstrip().split())
poketmonDogam = {}
poketmonDogam[0] = '0'
for i in range(1, N+1):
    poketmonDogam[i] = sys.stdin.readline().rstrip()
poketmonDogam2 = {v:k for k,v in poketmonDogam.items()}

for j in range(M):
    a = sys.stdin.readline().rstrip()
    if not a.isdigit(): # 문자열인경우
        print(poketmonDogam2[a])
    else:
        print(poketmonDogam[int(a)])



