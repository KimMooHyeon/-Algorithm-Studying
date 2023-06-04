from collections import deque


def bfs(startY, startX, myMap, n):
    answer = 0
    xOffset = [0, 0, 1, -1]
    yOffset = [1, -1, 0, 0]
    queue = deque()
    myMap[startY][startX] = '0'
    queue.append([startY, startX])
    while len(queue) > 0:
        curQueue = queue.popleft()
        answer += 1
        curY = curQueue[0]
        curX = curQueue[1]
        for i in range(4):
            nextY = curY + yOffset[i]
            nextX = curX + xOffset[i]
            if 0 <= nextY < n and 0 <= nextX < n and myMap[nextY][nextX] == '1':
                myMap[nextY][nextX] = '0'
                queue.append([nextY, nextX])
    return answer


answer = []
n = int(input().rstrip())
myMap = [[0 for i in range(n)] for j in range(n)]

for i in range(n):
    myMap[i] = list(input().rstrip())

for i in range(n):
    for j in range(n):
        if myMap[i][j] == '1':
            answer.append(bfs(i, j, myMap, n))
answer.sort()
print(len(answer))
for i in answer:
    print(i)
