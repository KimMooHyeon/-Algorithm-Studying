import sys
sys.setrecursionlimit(10**6)
xOffset = [0, 0, 1, -1]
yOffset = [1, -1, 0, 0]


def dfs(find, map, mapCheck, y, x, n):
    if mapCheck[y][x] and map[y][x] == find:
        mapCheck[y][x] = False
        for i in range(4):
            nextY = y + yOffset[i]
            nextX = x + xOffset[i]
            if 0 <= nextX < n and 0 <= nextY < n:
                if mapCheck[nextY][nextX] and map[nextY][nextX] == find:
                    dfs(find, map, mapCheck, nextY, nextX, n)


def dfsSpecial(map, mapCheckSpecial, y, x, n):
    if mapCheckSpecial[y][x] and (map[y][x] == "R" or map[y][x] == "G"):
        mapCheckSpecial[y][x] = False
        for i in range(4):
            nextY = y + yOffset[i]
            nextX = x + xOffset[i]
            if 0 <= nextX and nextX < n and 0 <= nextY and nextY < n:
                if mapCheckSpecial[nextY][nextX] and (map[y][x] == "R" or map[y][x] == "G"):
                    dfsSpecial(map, mapCheckSpecial, nextY, nextX, n)


n = int(input())
map = [["" for i in range(n)] for j in range(n)]
mapCheck = [[True for i in range(n)] for j in range(n)]
mapCheckSpecial = [[True for i in range(n)] for j in range(n)]

for i in range(n):
    temp = list(input())
    map[i] = temp
answer = 0
answerSpecial = 0

for i in range(n):
    for j in range(n):
        if mapCheck[i][j]:
            answer += 1
            dfs(map[i][j], map, mapCheck, i, j, n)

for i in range(n):
    for j in range(n):
        if map[i][j] == "R":
            map[i][j] = "G"

for i in range(n):
    for j in range(n):
        if mapCheckSpecial[i][j]:
            answerSpecial += 1
            dfs(map[i][j], map, mapCheckSpecial, i, j, n)

print(f'{answer} {answerSpecial}')
