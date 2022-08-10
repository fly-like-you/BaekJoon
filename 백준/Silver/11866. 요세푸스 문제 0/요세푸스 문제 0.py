n, k = map(int, input().split())
queue = []
for i in range(1, n+1):
    queue.append(i)
index = k - 1
li = []
print('<',end='')
while queue:
    if index < len(queue):
       li.append(queue[index])
       index += k
    else:
        index -= len(queue)
        for i in li:
            queue.remove(i)
            print(i, end='')
            if queue:
                print(', ', end='')
        li.clear()
print('>')


