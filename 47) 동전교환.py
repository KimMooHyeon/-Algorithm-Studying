import sys
#sys.stdin=open("input.txt", "r")
def dfs(num,sum_num):
    global n_arr
    global m
    global answer
    # num 동전의 개수, sum_num 현재까지 금액
    if num>answer:
        return
    elif sum_num == m :
        answer=min(num,answer)
        return
    elif sum_num > m :
        return
    else:
        for i in n_arr :
            tmp=i
            dfs(num+1,sum_num+tmp)

n = int(input())
n_arr=list(map(int,input().split()))
m = int(input())

n_arr.sort(reverse=True)
answer=2147483674
dfs(0,0)
print(answer)