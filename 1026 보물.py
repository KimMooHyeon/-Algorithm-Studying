T = int(input())

def S(A_arr,B_arr):
    B_arr_sort=[]
    min_num = 0
    for i,v in enumerate(B_arr):
        B_arr_sort.append((i,v))
    A_arr.sort(reverse=True)
    B_arr_sort.sort(key = lambda x : x[1])
  
    for i in range(T):
        min_num+= A_arr[i]*B_arr_sort[i][1]

    return min_num



A_arr= list(map(int, input().split()))
B_arr= list(map(int, input().split()))

print(S(A_arr,B_arr))
