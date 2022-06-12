import sys
#sys.stdin=open("input.txt","rt")

N,M = map(int,input().split())
#L = int(input())
L_arr= list(map(int,input().split()))
#M = int(input())
L_arr.sort(reverse=True)

lf=0
rf=N-1
cnt=0

now_sum=L_arr[lf]
while lf<=rf:

    if rf == lf :
       
        cnt+=1
        break
    if now_sum+L_arr[rf]==M:
       
        cnt+=1
        lf+=1
        rf-=1
        now_sum=L_arr[lf]
    elif now_sum+L_arr[rf]<M:
    
        rf-=1
        now_sum+=L_arr[rf]
    elif now_sum+L_arr[rf]>M:
     
        cnt+=1
        lf+=1
        now_sum=L_arr[lf]

print(cnt)