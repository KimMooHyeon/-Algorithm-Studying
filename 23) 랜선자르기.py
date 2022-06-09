import sys
#sys.stdin=open("input.txt","rt")


N,K = map(int,input().split())
#N = int(input())
#N_arr=list(map(int,input().split()))
N_arr=[]
res=0
res1=0
for i in range(N):
    tmp=int(input())
    res1+=tmp
    N_arr.append(tmp)


res1=res1//K 

lf=1
rf=max(N_arr)
middle=(lf+rf)//2
while lf<=rf :

    arr_sum=0
    middle=(lf+rf)//2
    for i in N_arr :
        arr_sum+=i//middle

    if arr_sum>=K:
        res=middle
        lf=middle+1
    elif arr_sum<K:
        rf=middle-1
 

print(res)



        