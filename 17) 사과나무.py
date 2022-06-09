import sys
import math
#sys.stdin=open("input.txt","rt")

#N = map(int,input().split())
N= int(input())
N_arr=[list(map(int,input().split())) for _ in range(N)]


cnt=1
middle_num= N//2 
res_sum=sum(N_arr[middle_num][0:N])
while True :
    res_sum+=sum(N_arr[middle_num-cnt][cnt:N-cnt])
    res_sum+=sum(N_arr[middle_num+cnt][cnt:N-cnt])
    cnt+=1
    if middle_num-cnt<0:
        break
    
print(res_sum)




    
  
