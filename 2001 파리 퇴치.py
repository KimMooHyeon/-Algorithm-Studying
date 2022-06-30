import sys
sys.stdin=open("input.txt", "r")

T = int(input())

for test_case in range(1, T + 1):
    
    N,M =map(int,input().split())
    map_nrr=[]
    res=0

    for i in range(N):
        tmp= list(map(int,input().split(' ')))
        map_nrr.append(tmp)
    
    # 행
    for i in range(N-M+1):
        #열
        for j in range(0,N-M+1):
            cnt=0
            for k in range(i,i+M):
                cnt+=sum(map_nrr[k][j:j+M])
            res=max(res,cnt) 
    print(f"#{test_case} {res}")




  