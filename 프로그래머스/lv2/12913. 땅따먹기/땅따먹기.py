import sys

sys.setrecursionlimit(1000001)

def findDp(y,x,dp,land,nowNum):
    if y == 0 :
        return land[y][x]
    if dp[y][x] != 0:
        if dp[y][x] < nowNum:
            dp[y][x] = nowNum
        return dp[y][x]
    else:
        maxIndex =0
        maxNum = 0
        for i in range(4):
            if x!= i :
                if maxNum<findDp(y-1,i,dp,land,nowNum):
                    maxIndex = i
                    maxNum = findDp(y-1,i,dp,land,nowNum)
        dp[y][x] = maxNum + land[y][x]
        return maxNum + land[y][x]
    

def solution(land):
    answer = 0
    dp = [[0 for i in range(4)] for j in range(len(land))]
    N = len(land)-1
    for i in range(4):
        dp[0][i] = land[0][i]   
    for i in range(4):
        findDp(N,i,dp,land,0)
    
    return max(dp[N])