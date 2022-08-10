import math
a,b,v = map(int, input().split())
left = v-a
rising = a-b
day = left / rising

print(math.ceil(day)+1)