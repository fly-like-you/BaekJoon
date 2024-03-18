import sys

input = sys.stdin.readline

T = int(input())

for _ in range(T):
    CMDs = list(input().rstrip())
    length = int(input())
    arr = input().strip("[]\n").split(',')


    reverse_flag = 1
    # -1 회전 1 회전 안함
    front = 0
    for cmd in CMDs:
        if cmd == 'R':
            reverse_flag *= -1

        elif cmd == 'D':
            if reverse_flag == 1:
                front += 1
            elif reverse_flag == -1:
                length -= 1

    if length >= front:

        if reverse_flag == 1:
            print("[" + ",".join(arr[front:length]) + "]")
        else:
            if front == 0:
                print(f'[{",".join(arr[length - 1::-1])}]')
            else:
                print(f'[{",".join(arr[length - 1:front - 1:-1])}]')
    else:
        print('error')




