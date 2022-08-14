import math
num = int(input())
smallBagKG = 3
bigBagKG = 5
smallBag = 0
bigBag = 0
count = math.ceil(num / smallBagKG)
while True:
    leftBag = num - (smallBag * smallBagKG)
    if smallBag > count:
        smallBag = -1
        bigBag = 0
        break
    if leftBag % bigBagKG == 0:
        bigBag = leftBag // bigBagKG
        break
    smallBag += 1

print(smallBag + bigBag)