N = int(input())
M = int(input())
S = input()
# IOI N=1 0~2
# IOIOI N=2 0~4
# IOIOIOI N=3  0~6
io_match = "IO" * N + "I"
def isNio(n, io_string, i):
    start = i
    end = i + 2 * n

    if end >= len(io_string):
        return False

    target = io_string[start:end + 1]
    if target == io_match:
        return True
    else:
        return False




count = 0
for i in range(len(S)):
    if isNio(N, S, i):
        count += 1

print(count)