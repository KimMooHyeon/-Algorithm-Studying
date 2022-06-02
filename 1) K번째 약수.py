
import sys
#sys.stdin=open("input.txt","rt")

N,K = map(int,input().split(" "))
sol_arr=[]
for i in range(1,N+1):
    if i*i>N :
        break

    if N%i == 0 :
        sol_arr.append(i)
        sol_arr.append(N//i)

sol_arr=list(set(sol_arr))
sol_arr.sort()

if K > len(sol_arr):
    print(-1)

else :
    print(sol_arr[K-1])

    