import copy
N = list(input())
N_int = int(''.join(N))
button_list = set(['0', '1', '2', '3', '4', '5', '6', '7', '8', '9'])
M = int(input())
broken_btn = set()
if M != 0:
    broken_btn = set(input().split())

now_channel = 100
button_list = button_list - broken_btn

def channel_in_list(large_channel_str):
    for n in range(len(large_channel_str)):
        if large_channel_str[n] not in button_list:
            return False
    return True


use_only_plus_click = abs(N_int - 100)


# 가장 가까운 채널에서 -를 눌러 채널을 맞추는 경우
channel_list = copy.deepcopy(N)
channel_click = 0
s_channel_int = N_int
l_channel_int = N_int

if button_list == set():
    print(use_only_plus_click)
    exit(0)
while True:
    # 버튼 리스트 안에 목적 채널의 버튼이 모두 존재하면 종료
    if channel_in_list(str(s_channel_int)):
        channel_click += N_int - s_channel_int
        channel_click += len(list(str(s_channel_int)))
        break
    if channel_in_list(str(l_channel_int)):
        channel_click += l_channel_int - N_int
        channel_click += len(list(str(l_channel_int)))

        break

    # 채널 증가
    s_channel_int -= 1
    l_channel_int += 1

print(min(channel_click, use_only_plus_click))