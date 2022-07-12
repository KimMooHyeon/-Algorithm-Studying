N,M=map(int,input().split())
N_arr=[]
N_arr=[0]*(N+1)

def dfs(res_arr,cnt):
    if cnt == M :
        for j in res_arr:
            print(j, end = ' ')
        print("")
        return
    else:
        for i in range(1,N+1):
            if N_arr[i]==0:
                N_arr[i]=1
                res_arr.append(i)
                dfs(res_arr,cnt+1)
                res_arr.pop()
                N_arr[i]=0
dfs([],0)