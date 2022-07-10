N=int(input())

N_arr= list(map(int , input().split()))

M=max(N_arr)
N_arr_tmp=list(map(lambda x: x/M*100,N_arr))

print(sum(N_arr_tmp)/len(N_arr_tmp))