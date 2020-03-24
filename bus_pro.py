T = int(input())

def sol(K,N,M_list) :
    cnt=0
    start=0

    while True:
        start+=K
        for i in range(start,start-K,-1):
            if start>= N:
                return cnt
            elif i in M_list:
                cnt+=1
                start=i
                break
            elif i not in M_list and i == start-K+1:
                return 0


for test_case in range(1, T + 1):
    K, N, M = map(int, input().split())
    M_list = list(map(int, input().split()))
    print("#{} {}".format(test_case, sol(K, N, M_list)))

