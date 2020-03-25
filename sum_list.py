def sol(N,M,ai) :
    temp=[]
    sum=0
    for i in range(0,N-M+1):
        sum+=ai[i]
        for j in range(i+1,i+M):
            sum+=ai[j]
        temp.append(sum)
        sum=0
    return max(temp)-min(temp)

T = int(input())

for test_case in range(1, T + 1):

    N, M = map(int, input().split())
    ai=list(map(int, input().split()))
    print("#{} {}".format(test_case,sol(N,M,ai)))
