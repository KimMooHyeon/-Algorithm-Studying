import sys
sys.stdin=open("input.txt", "r")

def change_func(arr):
    global N
    re_arr=[]
    tmp_arr=[]
    for i in range(0,N):
        tmp_arr=[]
        for j in range(N-1,-1,-1):
            tmp_arr.append(str(arr[j][i]))
        re_arr.append("".join(tmp_arr))
    return re_arr



T = int(input())

for test_case in range(1, T + 1):
    
    N=int(input())

    map_nrr=[]
    res=0

    for i in range(N):
        tmp= list(map(int,input().split(' ')))
        map_nrr.append(tmp)
    
    arr_90=change_func(map_nrr)
    arr_180=change_func(change_func(map_nrr))
    arr_270=change_func(change_func(change_func(map_nrr)))
    print(f"#{test_case}")
    for i in range(N):
        print(f"{arr_90[i]} {arr_180[i]} {arr_270[i]}")

    


