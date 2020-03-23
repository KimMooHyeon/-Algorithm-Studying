T = int(input())

def sol(K,N,M_list):

    for i in range(0,len(M_list)-1):
        if M_list[i+1]-M_list[i]>K or M_list[0]>K:
            return 0
    return  N//K

for test_case in range(1, T + 1):

    K,N,M = map(int, input().split())
    M_list = list(map(int, input().split()))
    print("#{} {}".format(test_case,sol(K,N,M_list)))

