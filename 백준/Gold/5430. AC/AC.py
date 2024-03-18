# 4
# RDD
# 4
# [1,2,3,4]

#output
# [2,1]
# error
def R(arr):
    arr.reverse()

def D(arr:list):
    if len(arr) == 0:
        return False

    arr.pop(0)
    return True


def arr_p(arr):
    return "[" + ",".join(map(str, arr)) + "]"


T = int(input())

for _ in range(T):
    CMDs = list(input())
    length = int(input())
    if length:
        arr = list(map(int, input()[1:-1].split(',')))
    else:
        _ = input()
        arr = []

    code = True
    reverse_flag = False
    for cmd in CMDs:
        if cmd == 'R':
            if reverse_flag:
                reverse_flag = False
            else:
                reverse_flag = True

        else:
            if len(arr) == 0:
                code = False
                print('error')
                break

            if reverse_flag:
                arr.pop(-1)
            else:
                arr.pop(0)

    if code:
        if reverse_flag:
            R(arr)
            print(arr_p(arr))
        else:
            print(arr_p(arr))



