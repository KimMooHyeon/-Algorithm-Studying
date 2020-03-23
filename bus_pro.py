T = int(input())
sol=[]
def sol(K,N,M_list):
    space = 0
    for i in range(0,len(M_list)-1):
        if M_list[i+1]-M_list[i]>K or M_list[0]>K:
            return 0
    for i in range (0,N):
        






for test_case in range(1, T + 1):
    K,N,M = map(int, input().split())
    M_list = list(map(int, input().split()))

