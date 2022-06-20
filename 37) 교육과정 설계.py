import sys
from collections import deque
#sys.stdin=open("input.txt","rt")

object_name2= input()
object_name=deque(list(object_name2))
N= int(input())
N_arr=[]
answer=[]
for i in range(N):
    N_arr.append(input())

N_arr=deque(N_arr)

for arr in N_arr:
    object_name=deque(list(object_name2))
    cnt=0
    for index in range(0,len(arr)):
        
        if arr[index] in object_name :
            
            if arr[index] == object_name[0]:
                object_name.popleft()
            else:
                answer.append("NO")
                break
    else:
        if object_name:
            answer.append("NO")
        else:
            answer.append("YES")

for i in range(0,len(answer)):
    print("#{} {}".format(i+1,answer[i]))