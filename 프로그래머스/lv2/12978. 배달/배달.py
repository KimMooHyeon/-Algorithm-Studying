def solution(N, road, K):
    answer = 0
    mapList = []
    for i in range(0,N):
        mapList.append([500001 for i in range(0,N)])
    
    for i in road:
        if mapList[i[0]-1][i[1]-1] > i[2]:
            mapList[i[0]-1][i[1]-1] = i[2]
            mapList[i[1]-1][i[0]-1] = i[2]

    for k in range(0,N): 
        for i in range(0,N): 
            for j in range(0,N): 
                if mapList[i][j]> mapList[i][k]+mapList[k][j] :
                    mapList[i][j] =mapList[i][k]+mapList[k][j]
                    mapList[j][i] =mapList[i][k]+mapList[k][j]
    for i in range(0,N): 
        mapList[i][i]= 500001
        
    for i in range(0,N): 
        if mapList[0][i] <=K :
            answer+=1
    print(mapList)
    return answer+1