import sys
from collections import deque
#sys.stdin=open("input.txt","rt")

dic_str={}
N = int(input())

for i in range(N):
    a=input()
    if a in dic_str:
        dic_str[a]-=1
    else:
        dic_str[a]=1
for i in range(N-1):
    a=input()
    if a in dic_str:
        dic_str[a]-=1
    else:
        dic_str[a]=1

for key, value in dic_str.items():
    if value==1:
        print(key)
        break


