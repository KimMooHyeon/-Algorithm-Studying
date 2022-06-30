
T = int(input())

for test_case in range(1, T + 1):
    
    N,M =map(int,input().split())
    A_arr= list(map(int,input().split()))
    B_arr= list(map(int,input().split()))
    max_num= -2147483648
    
    if N <M :
        # B가 더 길 경우 
        for i in range(0,M-N+1) : 
            cnt=0
            for j in range(0,len(A_arr)):
                cnt+= A_arr[j]*B_arr[j+i]
            max_num=max(cnt,max_num)
    else:
        # A가 더 길 경우 
        for i in range(0,N-M+1) : 
            cnt=0
            for j in range(0,len(B_arr)):
                cnt+= B_arr[j]*A_arr[j+i]
            max_num=max(cnt,max_num)

    print(f"#{test_case} {max_num}")




  