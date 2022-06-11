import sys
#sys.stdin=open("input.txt","rt")

n=int(input())
#N,C = map(int,input().split())
n_arr=[]
res_arr=[]
for i in range(n):
    N,C = map(int,input().split())
    n_arr.append((N,C))
n_arr.sort()
cnt=0
for i in range(n-1):
    for j in range(i+1,n):
        if n_arr[i][1]<n_arr[j][1]:
            res_arr.append((n_arr[i][0],n_arr[i][1]))
            break
    else:
        pass
        
        

n_arr.sort(key = lambda x : (x[1],x[0])  )

for i in range(n-1):
    for j in range(i+1,n):
        if n_arr[i][0]<n_arr[j][0]:
            res_arr.append((n_arr[i][0],n_arr[i][1]))
            break
    else:
        pass
res_arr=list(set(res_arr))      
       # cnt+=1     
print(n- len(res_arr))