import sys
#sys.stdin=open("input.txt","rt")

#H,W = map(int,input().split())
L = int(input())
L_arr= list(map(int,input().split()))
M = int(input())
L_arr.sort()

for i in range(M):
    L_arr[L_arr.index(max(L_arr))]-=1
    L_arr[L_arr.index(min(L_arr))]+=1
print(max(L_arr)-min(L_arr))    
  