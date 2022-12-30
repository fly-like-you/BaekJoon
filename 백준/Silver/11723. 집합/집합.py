import sys
n = int(sys.stdin.readline())
i = 0
S = []
while True:
  k = sys.stdin.readline().split()
  if k[0] == 'add':
    if int(k[1]) in S:
      pass
    else:
      S.append(int(k[1]))
  if k[0] == 'remove':
    if int(k[1]) in S:
      S.remove(int(k[1]))
    else:
      pass
  if k[0] == 'check':
    if int(k[1]) in S:
      print(1)
    else:
      print(0)
  if k[0] == 'toggle':
    if int(k[1]) in S:
      S.remove(int(k[1]))
    else:
      S.append(int(k[1]))
  if k[0] == 'all':
    S = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20]
  if k[0] == 'empty':
    S.clear()
  i = i + 1
  if i == n:
    break