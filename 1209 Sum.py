import sys
sys.stdin=open("input.txt", "r")




for test_case in range(1, 10 + 1):
    T = int(input())
    tmp_arr=[]
    res=0
    for i in range(100):
        tmp=list(input().split())
        tmp_arr.append(tmp)
    ans_arr=[]

    a_arr=0
    b_arr=0
    c_arr=0
    d_arr=0
    for i in range(100):
        a_tmp=0
        b_tmp=0
        for j in range(100):
            a_tmp+=int(tmp_arr[i][j])
            b_tmp+=int(tmp_arr[j][i])
            if i == j :
                c_arr+=int(tmp_arr[j][i])
            if i+j == 99 :
                d_arr+=int(tmp_arr[i][j])
        a_arr=max(a_arr,a_tmp)
        b_arr=max(b_arr,b_tmp)


    print(f"#{test_case} {max(a_arr,b_arr,c_arr,d_arr)}")



