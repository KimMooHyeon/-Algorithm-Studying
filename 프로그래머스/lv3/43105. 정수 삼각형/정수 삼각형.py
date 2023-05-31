def solution(triangle):
    dpList = []
    for i in triangle:
        temp = []
        for j in range(len(i)):
            temp.append(0)
        dpList.append(temp)
    dpList[0][0]=triangle[0][0]
    for i in range(1,len(dpList)):
        dpList[i][0]=dpList[i-1][0]+triangle[i][0]
        dpList[i][-1]=dpList[i-1][-1]+triangle[i][-1]
    for i in range(2,len(dpList)):
        for j in range(1,len(dpList[i])-1):
            dpList[i][j] = max(dpList[i-1][j],dpList[i-1][j-1])+triangle[i][j]

    return max(dpList[-1])