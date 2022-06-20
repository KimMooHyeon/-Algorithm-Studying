import sys
#sys.stdin=open("input.txt","rt")

answer=0

N,K = map(int,input().split())

prince_arr=[] 
res_arr=[]
for i in range(N) :
    prince_arr.append(i+1)

cnt=0
index=-1
while len(prince_arr)!=1 :

    cnt+=1
    index+=1
    if index>=len(prince_arr):
        index-=len(prince_arr)
    if cnt == K:
        cnt=0

        prince_arr.pop(index)
        index-=1

print(prince_arr[0])

