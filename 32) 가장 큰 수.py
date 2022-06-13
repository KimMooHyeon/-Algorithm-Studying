import sys
#sys.stdin=open("input.txt","rt")

N,M = map(int,input().split())

#N_arr= list(map(int,input().split()))

res_arr=[]
N_arr=[]
cnt=0
index=1
for i in str(N) :
    N_arr.append(int(i))

res_arr.append(N_arr[0])

while cnt<M and index < len(N_arr)  :

    while res_arr:
        
        if res_arr[-1] < N_arr[index]:
            res_arr.pop()
            cnt+=1
  
            if cnt>=M :
                break
        else: 
            break
    res_arr.append(N_arr[index])
    if cnt>=M :
        res_arr+=N_arr[index+1:len(N_arr)]
       
        break
                
    index+=1
    if index >= len(N_arr) and cnt <M :
        for i in range(0,M-cnt):
            res_arr.pop()



res=""    

for i in res_arr:
    print(i,end ='')


    

