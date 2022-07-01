import sys
from collections import deque
sys.stdin=open("input.txt", "r")
N=input()
res=""
N_queue=deque()

for index,i in enumerate(N) :
    if i =='<' :
        while N_queue:
            res+=N_queue.pop()
        N_queue.append(i)
    elif i =='>':
        while N_queue:
            res+=N_queue.popleft()
        res+=i
    elif i==' ':
        if '<' in N_queue:
            N_queue.append(i)
        else:
            while N_queue:
                res+=N_queue.pop()
            res+=i
    else:
        N_queue.append(i)

while N_queue:
    res+=N_queue.pop()

print(res)