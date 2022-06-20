import sys
from collections import deque
#sys.stdin=open("input.txt","rt")

N1_ARR={}
N2_ARR={}
N1 = input()
N2 = input()
for i in N1 :
    N1_ARR[i]= N1_ARR.get(i,0)+1
    
for i in N2 :
    N2_ARR[i]= N2_ARR.get(i,0)+1

if N1_ARR == N2_ARR :
    print("YES")
else:
    print("NO")



