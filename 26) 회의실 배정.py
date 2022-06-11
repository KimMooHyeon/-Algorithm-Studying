import sys
#sys.stdin=open("input.txt","rt")

n=int(input())
#N,C = map(int,input().split())
n_arr=[]

for i in range(n):
    N,C = map(int,input().split())
    n_arr.append((N,C))
n_arr.sort(key = lambda x : (x[1],x[0])  )
cnt=0
et=0
for i in range(0,n) :
    if n_arr[i][0]>=et:
        cnt+=1
        et=n_arr[i][1]
print(cnt)
