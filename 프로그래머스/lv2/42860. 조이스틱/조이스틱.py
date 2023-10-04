from collections import deque


def solution(name):
    target_name = list(name)
    name = ["A"] * len(name)
    count = 0
    pointer = 0
    while target_name != name:
        # move
        pointer, c = index_move(pointer, target_name, name)
        count += c
        # change
        count += alphabet_move(target_name[pointer])
        name[pointer] = target_name[pointer]

    return count


def alphabet_move(target):
    up_move = abs(ord("A") - ord(target))
    down_move = abs(ord("Z") - ord(target)) + 1
    return min(up_move, down_move)


def index_move(pointer, target_name, name):
    up_pointer = pointer # right
    down_pointer = pointer # left
    up_count = 0
    down_count = 0
    
    while target_name[up_pointer] == name[up_pointer]:
        up_pointer += 1
        up_count += 1
        if up_pointer >= len(name):
            up_pointer //= len(name)
            
    while target_name[down_pointer] == name[down_pointer]:
        down_pointer -= 1
        down_count += 1
        if down_pointer < 0:
            down_pointer += len(name)

    return min(up_pointer, down_pointer), min(up_count, down_count)

solution("JAN")