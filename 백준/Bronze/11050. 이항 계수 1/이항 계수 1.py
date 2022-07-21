n,k = map(int, input().split())
def fac(n):
    facto = 1
    for i in range(1,n+1):
        facto *= i
    return facto

print(int(fac(n)/(fac(k)* fac(n-k))))
