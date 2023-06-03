from collections import deque

def bfs(desY,desX,dp,maps):
    global answer
    xOffset = [0,0,1,-1]
    yOffset = [1,-1,0,0]
    queue = deque()
    queue.append([0,0,0])
    while len(queue)>0:
        curQueue =queue.popleft()
        curY = curQueue[0]
        curX = curQueue[1]
        curCost = curQueue[2]
        if curY == len(maps)-1 and curX == len(maps[0])-1:
            answer = curCost
            return
        else:
            if dp[curY][curX]<curCost:
                continue
            else:
                dp[curY][curX]=curCost
                
            for i in range(4):
                nextX = curX +xOffset[i]
                nextY = curY +yOffset[i]
                if 0<=nextX<len(maps[0]) and 0<=nextY<len(maps) and maps[nextY][nextX] ==1 :
                    if dp[nextY][nextX]>curCost+1:
                        dp[nextY][nextX]=curCost+1
                        queue.append([nextY,nextX,curCost+1])
answer = -1
def solution(maps):
    global answer
    wallMax = 100000
    dp=[[100000 for i in range(len(maps[0]))] for j in range(len(maps))]
    bfs(len(maps)-1,len(maps[0])-1,dp,maps)
    if answer !=-1:
        answer+=1
    return answer
