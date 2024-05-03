def solution(str_len, strings):
    length = 0
    pal_count = 0
    def is_palindrome(str_len, string):
        for i in range(str_len):
            if string[i] != string[str_len - i - 1]:
                return False
        return True

    for idx, string in enumerate(strings):
        if is_palindrome(str_len, string) and pal_count == 0:
            length += str_len
            pal_count += 1
        elif string[::-1] in strings[idx+1:]:
            length += str_len * 2

    return length


T = int(input())
for t in range(T):
    N, M = map(int, input().split())
    strings = []
    for _ in range(N):
        strings.append(input())

    print(f'#{t+1} {solution(M, strings)}')