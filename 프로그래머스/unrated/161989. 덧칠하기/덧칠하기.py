def solution(n, m, section):
    answer = 0
    paintMap = [] 
    for i in range(0,n):
        paintMap.append(False)
    for i in section :
        paintMap[i-1] = True
    for i in range(0,n):
        if paintMap[i] :
            answer+=1
            for j in range(i,i+m):
                if j >=n :
                    break
                else:
                    paintMap[j] = False
    return answer