from collections import deque


def bfs(myMap, dp, n, m):
    global answer
    queue = deque()
    queue.append([0, 0, 0])
    xOffset = [0, 0, 1, -1]
    yOffset = [1, -1, 0, 0]

    while len(queue) > 0:
        curQueue = queue.popleft()
        curY = curQueue[0]
        curX = curQueue[1]
        curCost = curQueue[2]
        if curY == n - 1 and curX == m - 1:
            answer = curCost + 1
            return

        for i in range(4):
            nextY = curY + yOffset[i]
            nextX = curX + xOffset[i]
            #print(f'{nextY} {nextX}')
            if 0 <= nextY < n and 0 <= nextX < m and myMap[nextY][nextX] == '1' and dp[nextY][nextX] > curCost + 1:
              #  print("들어옴")
                dp[nextY][nextX] = curCost + 1
                queue.append([nextY, nextX, curCost + 1])


answer = 0
(n, m) = map(int, input().rstrip().split(" "))
myMap = [[0 for i in range(m)] for j in range(n)]
dp = [[100000 for _ in range(m)] for _ in range(n)]
for i in range(n):
    myMap[i] = list(input())

bfs(myMap, dp, n, m)
print(answer)
