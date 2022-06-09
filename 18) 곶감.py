import sys
#sys.stdin=open("input.txt","rt")

def change_num(lr,change_num,one_arr):
    global N 
    change_num=change_num%N
    res_list=[]
    if lr == 1:
        #오른쪽으로
        for i in range(N):
            res_list.append(one_arr[i-change_num])
    else : 
        #왼쪽으로
        for i in range(N):
            if i+change_num>=N:
                res_list.append(one_arr[i+change_num-N])

            else:
                res_list.append(one_arr[i+change_num])
    return res_list


#N = map(int,input().split())
N= int(input())
N_arr=[list(map(int,input().split())) for _ in range(N)]
K= int(input())
K_arr=[list(map(int,input().split())) for _ in range(K)]
res=0
start=0
cnt=0
for i in K_arr :
    N_arr[i[0]-1]=change_num(i[1],i[2],N_arr[i[0]-1])

for i in range(0,N//2):
    res+=sum(N_arr[i][0+cnt:N-cnt])
    res+=sum(N_arr[N-i-1][0+cnt:N-cnt])


    cnt+=1

res+=N_arr[N//2][N//2]
print(res)



    
  
