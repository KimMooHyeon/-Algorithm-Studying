T = int(input())

for test_case in range(1, T + 1):
    print(f"#{test_case}")
    N=int(input())
    N_arr=[]
    cnt=0
    for i in range(N):
        A,B =map(str,input().split())
        for i in range(int(B)):
            print(A,end='')
            cnt+=1
            if cnt%10 ==0:
                print("")
    print()