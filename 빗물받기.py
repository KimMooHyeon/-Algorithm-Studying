import sys
#sys.stdin=open("input.txt","rt")

H,W = map(int,input().split())

W_arr= list(map(int,input().split()))
sum_arr=[]
cnt=0
max_height=W_arr[0]
for i in range(1,len(W_arr)) :
  
    if max_height == 0:
        continue

    if W_arr[i] > max_height:
        for j in sum_arr:
            cnt+= max_height-j
        max_height=W_arr[i]
        sum_arr.clear()

    elif W_arr[i] == max_height:
        for j in sum_arr:
            cnt+= max_height-j
        sum_arr.clear()    
    else:
        if i == W-1:
            
            sum_arr.append(W_arr[i])
          
            max_num=max(sum_arr)
            for j in range(0,len(sum_arr)-1):
                if max_num==sum_arr[j]:
                    max_num=max(sum_arr[j+1:len(sum_arr)])
      
                else:
                    cnt+= max_num-sum_arr[j]      
 
        else:
            sum_arr.append(W_arr[i])
 
print(cnt)