from collections import deque
import sys
input = sys.stdin.readline
T = int(input())


def D(n: int):
    res = n * 2
    if res > 9999:
        res %= 10000
    return res


def S(n: int):
    if n == 0:
        return 9999
    return n - 1


def R(n: int):
    str_n = str(n)
    str_n = '0' * (4 - len(str_n)) + str_n
    return int(str_n[3] + str_n[0] + str_n[1] + str_n[2])


def L(n: int):
    str_n = str(n)
    str_n = '0' * (4 - len(str_n)) + str_n
    return int(str_n[1] + str_n[2] + str_n[3] + str_n[0])


for _ in range(T):
    N, M = map(int, input().split())

    # bfs로 탐색한다.
    def bfs(start):

        queue = deque([start])
        visited[start] = 1
        while queue:
            node = queue.popleft()
            if node == M:
                print(ans[node])
                break

            d = D(node)
            if not visited[d]:
                visited[d] = visited[node] + 1
                ans[d] = ans[node] + 'D'
                queue.append(d)

            s = S(node)
            if not visited[s]:
                visited[s] = visited[node] + 1
                ans[s] = ans[node] + 'S'
                queue.append(s)

            l = L(node)
            if not visited[l]:
                visited[l] = visited[node] + 1
                ans[l] = ans[node] + 'L'
                queue.append(l)

            r = R(node)
            if not visited[r]:
                visited[r] = visited[node] + 1
                ans[r] = ans[node] + 'R'
                queue.append(r)




    MAX = 10 ** 4
    visited = [0] * (MAX + 1)
    ans = [''] * (MAX + 1)
    bfs(N)
