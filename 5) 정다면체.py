import sys
#sys.stdin=open("input.txt","rt")

N,M = map(int,input().split())

#N_arr = list(map(int,input().split()))
res_arr=[]
num_arr=[]
set_num_arr=[]
for i in range(1,N+1):
    for j in range(1,1+M):
        num_arr.append(i+j)

set_num_arr=list(set(num_arr))
set_num_arr.sort()
max_num=0
for i in set_num_arr:
    if num_arr.count(i)>=max_num:
        max_num=num_arr.count(i)
for i in set_num_arr:
    if max_num==num_arr.count(i):
        res_arr.append(i)
res_arr.sort()

for i in res_arr:
    print(i,end = ' ')