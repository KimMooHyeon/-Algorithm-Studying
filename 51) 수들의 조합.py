import sys
from itertools import combinations
#sys.stdin=open("input.txt","rt")


N,K = map(int,input().split())
N_arr=list(map(int,input().split()))
M=int(input())
cnt=0
com_list=list(combinations(N_arr,K))
for i in com_list:
    if (sum(i)%M) == 0:
        cnt+=1
print(cnt)