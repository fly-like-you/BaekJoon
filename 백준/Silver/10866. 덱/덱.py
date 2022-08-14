import sys
queue = []

def push_front(num):
    queue.insert(0,num)

def push_back(num):
    queue.append(num)
def size():
    return len(queue)
def empty():
    if len(queue) == 0:
        return 1
    else:
        return 0

def pop_front():
    if empty():
        return -1
    return queue.pop(0)
def pop_back():
    if empty():
        return -1
    return queue.pop(-1)
def front():
    if empty():
        return -1
    return queue[0]
def back():
    if empty():
        return -1
    return queue[-1]

n = int(input())
for i in range(n):
    order = list(sys.stdin.readline().rstrip().split())
    if order[0] == 'push_front':
        push_front(order[1])
    elif order[0] == 'push_back':
        push_back(order[1])
    elif order[0] == 'front':
        print(front())
    elif order[0] == 'back':
        print(back())
    elif order[0] == 'empty':
        print(empty())
    elif order[0] == 'pop_front':
        print(pop_front())
    elif order[0] == 'pop_back':
        print(pop_back())
    elif order[0] == 'size':
        print(size())

