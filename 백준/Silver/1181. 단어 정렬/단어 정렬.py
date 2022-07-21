import sys
case = int(sys.stdin.readline().rstrip())
wordSet = set()
for i in range(case):
    word = sys.stdin.readline().rstrip()
    wordSet.add(word)

wordList = list(wordSet)
wordList.sort()
wordList.sort(key = len)
for i in wordList:
    print(i)