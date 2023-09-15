from copy import deepcopy


def solution(park, routes):
    park_graph = []

    for x in park:
        park_graph.append(list(x))

    col_len = len(list(zip(*park_graph))[0])

    now = []

    for i in range(len(park_graph)):
        for j in range(len(park_graph[i])):
            if park_graph[i][j] == "S":
                now = [i, j]

    for i in range(len(routes)):
        x, y = now[0], now[1]
        save = deepcopy(now)
        direct, distance = routes[i].split()
        distance = int(distance)


        if direct == "E":  # 오른쪽 y
            for i in range(distance):
                if now[1] + 1 >= len(park_graph[0]):  # park_graph[x][y + distance]
                    now = deepcopy(save)
                    break
                elif park_graph[now[0]][now[1] + 1] == "X":  # 장애물
                    now = deepcopy(save)
                    break
                else:
                    now[1] += 1

        elif direct == "W":
            for i in range(distance):
                if now[1] - 1 < 0:
                    now = deepcopy(save)
                    break
                elif park_graph[now[0]][now[1] - 1] == "X":  # 장애물
                    now = deepcopy(save)
                    break
                else:
                    now[1] -= 1
        elif direct == "S":
            for i in range(distance):
                if now[0] + 1 >= col_len:  # park_graph[x][y + distance]
                    now = deepcopy(save)
                    break
                elif park_graph[now[0] + 1][now[1]] == "X":  # 장애물
                    now = deepcopy(save)
                    break
                else:
                    now[0] += 1

        elif direct == "N":
            for i in range(distance):
                if now[0] - 1 < 0:  # park_graph[x][y + distance]
                    now = deepcopy(save)
                    break
                elif park_graph[now[0] - 1][now[1]] == "X":  # 장애물
                    now = deepcopy(save)
                    break
                else:
                    now[0] -= 1
    return now