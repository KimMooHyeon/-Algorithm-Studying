import sys
#sys.stdin=open("input.txt","rt")

def sol_num(N_arr):
    if N_arr[0]==N_arr[1]==N_arr[2]:
        sol_sum=10000+N_arr[0]*1000
    elif N_arr[0]!=N_arr[1] and N_arr[0]!=N_arr[2] and N_arr[1] != N_arr[2]:
        sol_sum=max(N_arr)*100
    else:
        if N_arr[0]==N_arr[1]:
            sol_sum=1000+N_arr[0]*100
        elif N_arr[0]==N_arr[2]:
            sol_sum=1000+N_arr[0]*100
        else:
            sol_sum=1000+N_arr[2]*100
    return sol_sum

N = int(input())
max_num=0
for i in range(N):
    N_arr = list(map(int,input().split()))
    if max_num < sol_num(N_arr):
        max_num=sol_num(N_arr)

print(max_num)