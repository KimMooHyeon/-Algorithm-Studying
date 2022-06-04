import sys
#sys.stdin=open("input.txt","rt")

def sosu(x):
    for i in range(2,x) :
       if x % i == 0:
           return True
           break
    else :
        return False

N = int(input())
cnt=0
ch_arr= [0]*(N+1)
for i in range (2,N+1):
    if ch_arr[i] == 0 :
        cnt+=1
 
        for j in range(i,N+1,i):     
            ch_arr[j]+=1

print(cnt)                


