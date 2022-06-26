import sys

n,k=map(int,input().split())
n_arr=[]
for i in range(n):
    tmp=int(input())
    n_arr.append(tmp)

n_arr.sort(reverse=True)
answer=0

while k >0:
    if k >= n_arr[0]:
        tmp= k//n_arr[0]
        answer+=tmp
        k=k%n_arr[0]
        n_arr.pop(0)
    else:
        n_arr.pop(0)

print(answer)

