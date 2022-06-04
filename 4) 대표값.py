import sys
#sys.stdin=open("input.txt","rt")

N = map(int,input().split())

N_arr = list(map(int,input().split()))
N_sum=0
for i in N_arr :
    N_sum+=i
avr_sum=N_sum/len(N_arr)
res_sum = int(avr_sum+0.5)
res_index=0
sol_pro = N_arr[0]
min_check=abs(N_arr[0]-res_sum)

for j in range(1,len(N_arr)):
    if N_arr[j]==sol_pro:
        continue
    if abs(N_arr[j]-res_sum)==min_check:
        if N_arr[j]<sol_pro:
            continue

    if abs(N_arr[j]-res_sum)<=min_check:
        min_check=abs(N_arr[j]-res_sum)
        res_index=j
        sol_pro= N_arr[j]

print(res_sum,res_index+1)


    
