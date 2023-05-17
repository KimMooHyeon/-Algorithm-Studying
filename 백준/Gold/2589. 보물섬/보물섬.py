import copy
from collections import deque

xOffset = [0, 0, 1, -1]
yOffset = [1, -1, 0, 0]

answer = 0


def bfs(map, y, x, check, ySize, xSize):
    global answer
    hash={}
    queue = deque()
    check[y][x] = False
    queue.append([y, x, 0, 0])

    while queue:
        curQueue = queue.popleft()
        answer = max(answer, curQueue[-1])
        for i in range(4):
            nextY = curQueue[0] + yOffset[i]
            nextX = curQueue[1] + xOffset[i]
            if 0 <= nextX < xSize and 0 <= nextY < ySize:
                if check[nextY][nextX] and map[nextY][nextX] == "L":
                    check[nextY][nextX] = False
                    if (nextY, nextX, i) in hash:
                        if hash[nextY, nextX, i] > curQueue[-1] + 1:
                            hash[nextY, nextX, i] = curQueue[-1] + 1
                            queue.append([nextY, nextX, i, curQueue[-1] + 1])
                    else:
                        hash[nextY, nextX, i] = curQueue[-1] + 1
                        queue.append([nextY, nextX, i, curQueue[-1] + 1])


# 육지로만 이동 가능, 이동은 1시간 걸림
# 보물은 육지 두곳에 나뉘어 묻힘
# 육지 두곳 최단거리를 같은 곳을 2번 이상 지나가면 안된다.
# 보물은 서로 간에 최단 거리로 이동하는데 있어 가장 긴 시간이 걸리는 육지 두 곳에 나뉘어 묻혀있다.

y, x = map(int, input().split(" "))

map = [["L" for i in range(x)] for j in range(y)]
check = [[True for i in range(x)] for j in range(y)]
LList = []
for i in range(y):
    map[i] = list(input())
    for j in range(x):
        if map[i][j] == "L":
            LList.append([i,j])

for i in LList:
    bfs(map, i[0], i[1], copy.deepcopy(check), y, x)

print(answer)