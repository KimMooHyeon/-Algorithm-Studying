import sys
#sys.stdin=open("input.txt","rt")


N,K = map(int,input().split())
#N = int(input())
lf=0
rf=N-1
middlef=N//2
N_arr=list(map(int,input().split()))
N_arr.sort()
cnt=0

while True :
    if N_arr[middlef] == K :
        cnt=middlef
        break
    elif N_arr[middlef] > K:
        rf=middlef
        middlef= (rf+lf)//2
    else:
        lf=middlef
        middlef= (rf+lf)//2
print(cnt+1)



        