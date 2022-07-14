N=int(input())
N_arr=[]
for i in range(N):
    tmp=input()
    N_arr.append(tmp)

N_arr=list(set(N_arr))
N_arr.sort(key= lambda x : (len(x),x))
for j in N_arr:
    print(j)