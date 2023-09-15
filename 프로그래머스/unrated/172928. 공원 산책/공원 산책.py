def detect_dog(park):
    for i in range(len(park)):
        for j in range(len(park[i])):
            if park[i][j] == "S":
                return i, j

class Dog:
    def __init__(self, x, y):
        self.x = x
        self.y = y
        self.g = {"N": (-1, 0), "W": (0, -1), "E": (0, 1), "S": (1, 0)}

    def move(self, park, direction, distance):
        i, j = self.g[direction]
        x, y = self.x + (i * distance), self.y + (j * distance)
        if x < 0 or y < 0 or x >= len(park) or y >= len(park[0]):
            return park
        elif "X" in park[x][min(self.y, y): max(self.y, y + 1)] or \
             "X" in [row[y] for row in park[min(self.x, x): max(self.x, x)]]:
            return park

        self.x = x
        self.y = y
        return park


def solution(park, routes):
    park = [list(row) for row in park]
    x, y = detect_dog(park)
    dog = Dog(x, y)

    for route in routes:
        direction, distance = route.split()
        park = dog.move(park, direction, int(distance))
    return [dog.x, dog.y]