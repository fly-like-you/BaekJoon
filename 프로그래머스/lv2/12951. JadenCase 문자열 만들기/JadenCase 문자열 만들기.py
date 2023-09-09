# split으로 구분하기
# 구분된 리스트에서 유니코드를 비교해서 알파벳인지 비교하고
def solution(s):
    # 단어의 정의 앞에 공백이 있고 현재 단어가 공백이 아니여야함
    # [h, e, l, l, o, , w, o, r, l, d]
    li = list(s)

    for idx, char in enumerate(li):

        if idx == 0:
            if isLowAlpha(char):
                li[idx] = changeLarge(char)
        else:
            if isLowAlpha(char):
                if li[idx-1] == ' ':
                    li[idx] = changeLarge(char)
            elif isAlpha(char):
                if li[idx-1] != ' ':
                    li[idx] = changeLow(char)

    return ''.join(li)

def isLowAlpha(word):
    return 97 <= ord(word) <= 122

def isLargeAlpha(word):
    return 65 <= ord(word) <= 90

def isAlpha(word):
    return 65 <= ord(word) <= 122

def changeLow(word):
    return chr(ord(word) + 32)

def changeLarge(word):
    return chr(ord(word) - 32)

