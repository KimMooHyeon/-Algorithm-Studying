def solution(n,a,b):
    answer = 0
    # 4번, 7번
    cnt=1
    # 1 2  3 4  5 6  7 8
    # 1 3 5 6
    tmp_arr=[]
    n_arr = list(range(1,n+1))
    while True:
        for i in range(0,len(n_arr),2):
            if (n_arr[i] == a and n_arr[i+1] == b)or(n_arr[i] == b and n_arr[i+1]== a):
                answer=cnt 
                return cnt
        else:
            for i in range(0,len(n_arr),2):
                if (n_arr[i] !=a and n_arr[i] !=b) :
                    if (n_arr[i+1] ==a or n_arr[i+1] ==b):
                        tmp_arr.append(n_arr[i+1])
                    else:
                        tmp_arr.append(n_arr[i+1])
                else:
                    tmp_arr.append(n_arr[i])           
            cnt+=1
            n_arr=tmp_arr.copy()
            tmp_arr.clear()

    return answer