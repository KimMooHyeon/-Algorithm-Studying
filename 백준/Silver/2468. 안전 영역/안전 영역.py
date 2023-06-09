import copy
import sys
sys.setrecursionlimit(100000)
xOffset = [0, 0, 1, -1]
yOffset = [1, -1, 0, 0]


def spread(num, myMap, n, y, x):
    global xOffset
    global yOffset
    if myMap[y][x] > num:
        myMap[y][x] = num
        for i in range(4):
            nextY = y + yOffset[i]
            nextX = x + xOffset[i]
            if 0 <= nextX < n and 0 <= nextY < n:
                if myMap[nextY][nextX] > num:
                    spread(num, myMap, n, nextY, nextX)


def sol(num, myMap, n):
    space = 0
    for y in range(n):
        for x in range(n):
            if myMap[y][x] > num:
                space += 1

                spread(num, myMap, n, y, x)

    #print(myMap)
    return space


n = int(input())
myMap = [[0 for i in range(n)] for j in range(n)]
minNum = 101
maxNum = 0
answer = 1
heightList = set([])
for i in range(n):
    temp = list(input().rstrip().split(" "))
    myMap[i] = list(map(int, temp))
    for j in myMap[i]:
        heightList.add(j)
tempList = sorted(list(heightList))
for num in tempList:
    myNum = sol(num, copy.deepcopy(myMap), n)
    answer = max(answer, myNum)

print(answer)
