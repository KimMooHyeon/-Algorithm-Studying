import sys
from itertools import combinations 
#sys.stdin=open("input.txt","rt")

N =int(input())
answer=[]
N_arr=[]
for i in range(N):
    a,b=map(int,input().split())
    N_arr.append([a,b])
for index,value in enumerate(N_arr):
    cnt=1
    for i,v in enumerate(N_arr):
        if i==index:
            pass
        else:
            if (value[0]<v[0]) and value[1]<v[1]:
                cnt+=1
    answer.append(str(cnt))

print(" ".join(answer))