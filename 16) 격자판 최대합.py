import sys
import math
#sys.stdin=open("input.txt","rt")

#N = map(int,input().split())
N= int(input())
N_arr=[list(map(int,input().split())) for _ in range(N)]
max_num=0
x_sum=0
for i in N_arr :
    if sum(i)>max_num:
        max_num=sum(i)
for j in range(0,N):
    now_sum=0
    for k in range (0,N) :
        now_sum+=N_arr[k][j]
        if j==k :
            x_sum+=N_arr[k][j]
    if now_sum>max_num:
        max_num=now_sum
    if max_num<x_sum:
        max_num=x_sum
print(max_num)


    
  
