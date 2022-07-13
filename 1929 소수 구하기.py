
M,N=map(int,input().split())


check_dp=[0]*(N+1)
sosu_arr=[]
for i in range(2,N+1):
    if check_dp[i] == 0 :
        if i >=M:
            print(i)
        i_num=i
        for j in range(i,N+1,i_num):
            check_dp[j]=1 
