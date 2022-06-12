import sys
#sys.stdin=open("input.txt","rt")

#N,M = map(int,input().split())
N = int(input())
N_arr= list(map(int,input().split()))

res_arr=[]

res_arr.append(N)
cnt=1
for i in range(N-1,0,-1) :

    if N_arr[i-1]==cnt :
        res_arr.insert(cnt,i)
    else:
        res_arr.insert(N_arr[i-1],i)
    cnt+=1


for i in res_arr:
    print (i, end=' ')

   

