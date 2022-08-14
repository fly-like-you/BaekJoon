import sys
front, rear = -1, -1
queue = []

def push(num):
    queue.append(num)


def size():
    return len(queue)
def empty():
    if len(queue) == 0:
        return 1
    else:
        return 0

def pop():
    if empty():
        return -1
    return queue.pop(0)
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
    if order[0] == 'push':
        push(order[1])
    elif order[0] == 'front':
        print(front())
    elif order[0] == 'back':
        print(back())
    elif order[0] == 'empty':
        print(empty())
    elif order[0] == 'pop':
        print(pop())
    elif order[0] == 'size':
        print(size())

