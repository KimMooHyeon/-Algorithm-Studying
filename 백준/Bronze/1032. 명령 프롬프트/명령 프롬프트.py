N=int(input())
N_arr=[]
res=""
for i in range(0,N):
    tmp=input()
    N_arr.append(tmp)
for j in range(0,len(N_arr[0])):

    for k in range(1,N):
        if N_arr[0][j] == N_arr[k][j]:
            pass
        else:
            res+="?"
            break
    else:
        res+=N_arr[0][j] 

print(res)

    