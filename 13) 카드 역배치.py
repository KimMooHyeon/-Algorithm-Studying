import sys
import math
#sys.stdin=open("input.txt","rt")

def change_arr(N,K):
    global N_arr
    #N부터 K까지 역순 변경
    a_arr=N_arr[N:K+1]
    a_arr.reverse()
    cnt=0
    #1부터 9까지 역순 변경
    for i in range (N,K+1):
        N_arr[i],a_arr[cnt]=a_arr[cnt],N_arr[i]
        cnt+=1
   # print(N,K, end =' ')
   # print(N_arr)
    

N_arr=[0]*21
for i in range(1,21):
    N_arr[i]=i


#N = input()
#N_arr = list(map(int,input().split()))

for i in range(10):
     N,K= map(int,input().split())
     change_arr(N,K)
for i in range(1,21):
    print(N_arr[i], end=' ')
