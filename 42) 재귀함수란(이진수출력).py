import sys
from collections import deque
def dfs(n):
    global ans_arr
    if n<2:
        ans_arr.appendleft(str(n%2))
        print(''.join(ans_arr))
    else:
        ans_arr.appendleft(str(n%2))
        dfs(n//2)
        

  #     2 11
   #        5   1
#sys.stdin=open("input.txt","rt")
ans_arr=deque()
n=int(input())
dfs(n)



