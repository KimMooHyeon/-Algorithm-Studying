import sys
from collections import deque
#sys.stdin=open("input.txt","rt")
answer=0
N= int(input())
N_arr= [x for x in range(1,N+1)]
N_arr=deque(N_arr)

while len(N_arr)!=1:
    N_arr.popleft()
    first=N_arr.popleft()
    N_arr.append(first)

print(N_arr[0])
