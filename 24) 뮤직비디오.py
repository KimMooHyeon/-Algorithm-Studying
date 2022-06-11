import sys
#sys.stdin=open("input.txt","rt")


N,K = map(int,input().split())
#N = int(input())
N_arr=list(map(int,input().split()))
res=sum(N_arr) 
lf=0
rf=sum(N_arr) 

while lf<=rf:
    now_sum=0
    now_cnt=0
    middle=(lf+rf)//2

    for i in N_arr:
        if now_sum+i<=middle:
            now_sum+=i
        else:
            now_cnt+=1
            now_sum=i

        if now_cnt>=K:
            lf=middle+1
            break
    else:
        now_cnt+=1
        rf=middle-1
        if res>middle:
            res=middle
  

if res < max(N_arr):
    res= max(N_arr)
print(res)



        