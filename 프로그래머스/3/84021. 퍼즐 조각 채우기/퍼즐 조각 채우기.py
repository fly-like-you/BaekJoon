import copy
from collections import deque

def bfs(arr, position, target):
    blocks = [[position[0], position[1]]]
    n = len(arr)
    di = [1, -1, 0, 0]
    dj = [0, 0, 1, -1]
    queue = deque([position])

    while queue:
        i, j = queue.popleft()
        for _ in range(4):
            ni = i + di[_]
            nj = j + dj[_]

            if 0 <= ni < n and 0 <= nj < n and arr[ni][nj] == target:
                arr[ni][nj] = 2
                blocks.append([ni, nj])
                queue.append([ni, nj])

    return blocks

def rotate(arr, n):
    rot_arr = [[0] * n for _ in range(n)]

    for i in range(n):
        for j in range(n):
            rot_arr[j][n-i-1] = arr[i][j]

    return rot_arr
def reg(block):
    dx, dy = block[0][0], block[0][1]
    return [[block[i][0] - dx, block[i][1] - dy] for i in range(len(block))]


def solution(game_board, table):
    answer = 0
    blocks = []
    n = len(game_board)
    for i in range(n):
        for j in range(n):
            if table[i][j] == 1:
                position = [i, j]
                table[i][j] = 2
                blocks.append(reg(bfs(table, position, 1)))

    for _ in range(4):
        game_board = rotate(game_board, n)
        game_board_copy = copy.deepcopy(game_board)

        for i in range(n):
            for j in range(n):
                if game_board_copy[i][j] == 0:
                    game_board_copy[i][j] = 2
                    whole = reg(bfs(game_board_copy, [i, j], 0))
                    if whole in blocks:
                        blocks.pop(blocks.index(whole))
                        # blocks에서 whole 제거
                        answer += len(whole)
                        game_board = copy.deepcopy(game_board_copy)
                    else:
                        game_board_copy = copy.deepcopy(game_board)

    return answer


