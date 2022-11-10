N = int(input())
count = [0]
def recursion(s, l, r): # s: 문자열, l: 인덱스, r: 맨 끝 부터의 인덱스
    count[0] += 1
    if l >= r: return 1 # l이 r과 같아지면 펠린
    elif s[l] != s[r]: return 0 # 문자가 틀리면 0
    else:
        return recursion(s, l+1, r-1) # ㅇㅇㅇㄴㄴㄴㄴㅂㅂㅂㅂㅂㅂ


def isPalindrome(s):
    return recursion(s, 0, len(s)-1)



for _ in range(N):
    count = [0]
    print(isPalindrome(input()), count[0])