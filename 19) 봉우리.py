import sys
#sys.stdin=open("input.txt","rt")

#N = map(int,input().split())
N= int(input())
N_arr=[list(map(int,input().split())) for _ in range(N)]
check_arr=[[False] * N  for _ in range(N)]
plus_arr=[-1,1,0,0]
minus_arr=[0,0,-1,1]
res_cnt=0

for i in range(0,N):
    for j in range(0,N):
        if check_arr[i][j]==False:
            for k in range(4):
                if i+plus_arr[k]<0 or i+plus_arr[k]>=N or j+minus_arr[k]<0 or j+minus_arr[k]>=N :
                    continue
                if N_arr[i][j]>N_arr[i+plus_arr[k]][j+minus_arr[k]]:
                    check_arr[i+plus_arr[k]][j+minus_arr[k]] = True
                else:
                    check_arr[i][j]= True
                    break
            else:
                res_cnt+=1
print(res_cnt)


    




    
  
