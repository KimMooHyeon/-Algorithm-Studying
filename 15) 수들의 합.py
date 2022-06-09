import sys
import math
#sys.stdin=open("input.txt","rt")

N,M = map(int,input().split())
N_arr = list(map(int,input().split()))
cnt=0

lf=0
rf=1
now_sum=N_arr[lf]
while True :

    if now_sum==M :
        cnt+=1
        now_sum-=N_arr[lf]
        lf+=1
    elif now_sum<M:
        if rf >= N :
            break
        now_sum+=N_arr[rf]
        rf+=1
    else:
        now_sum-=N_arr[lf]
        lf+=1
        

print(cnt)