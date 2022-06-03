import sys
#sys.stdin=open("input.txt","rt")

N,K = map(int,input().split())

N_arr = list(map(int,input().split()))
sol_arr=[]

sum_value=0
cnt=1
for i in range(0,N-2):
    sum_value=N_arr[i]
    for j in range(i+1,N-1):
        sum_value+=N_arr[j]
        for k in range(j+1,N):
            sum_value+=N_arr[k]
            sol_arr.append(sum_value)
            sum_value-=N_arr[k]
        sum_value-=N_arr[j]

sol_arr=list(set(sol_arr))
sol_arr.sort()

print(sol_arr[-K])


    
