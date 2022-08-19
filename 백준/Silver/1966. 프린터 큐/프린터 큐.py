N = int(input())
def moveBack(list):
    temp = list[0]
    del list[0]
    list.append(temp)


for _ in range(N):
    num, query = map(int, input().split())
    documentList = list(map(int, input().split()))
    count = 0
    while True:
        if documentList[0] == max(documentList):
            if query == 0:
                count += 1
                print(count)
                break
            else:
                documentList[0] = -1
                moveBack(documentList)
                query -= 1
                count += 1
        else:
            if query == 0:
                moveBack(documentList)
                query = len(documentList) - 1
            else:
                moveBack(documentList)
                query -= 1