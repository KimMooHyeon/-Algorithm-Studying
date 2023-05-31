def solution(m, n, puddles):
    answer = 0
    map = [[0 for i in range(m)] for j in range(n)]
    for i in puddles:
        if len(i) != 0:
            map[i[1]-1][i[0]-1]=-1
    for i in range(m):
        if map[0][i] == -1:
            break
        map[0][i]=1
    for i in range(n):
        if map[i][0]==-1:
            break
        map[i][0]=1
        
    for i in range(1,n):
        for j in range(1,m):
            if map[i][j]!=-1 :
                left = map[i][j-1]
                up =  map[i-1][j]
                num = 0
                if left != -1 :
                    num+=left
                if up != -1:
                    num+=up
                map[i][j] = num%1000000007

    return map[-1][-1]%1000000007