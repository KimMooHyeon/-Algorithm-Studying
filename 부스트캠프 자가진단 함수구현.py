import sys
import math
sys.stdin=open("input.txt","rt")




#N,M = map(int,input().split())
N_arr = list(map(int,input().split()))
res_arr=[]
check_arr=[]
for i in N_arr:
    if N_arr.count(i)>1 and i not in check_arr :
        check_arr.append(i)
        res_arr.append(N_arr.count(i))

if not res_arr:
    print(-1)
else:
    print(res_arr)