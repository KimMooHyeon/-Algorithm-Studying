import sys
#sys.stdin=open("input.txt","rt")

# 트럭의 제한은 C 킬로그램 이하
# N마리의 바둑이와, 바둑이의 무게 W 
# #바둑이를 가장 무겁게 태우기 

def dfs(n,weight,t_sum):
    global answer
    global N
    global C
    global N_arr
    if weight+(total-t_sum) < answer:
        return
    if weight>=C:
        return
    if n==N :
        if weight>answer:
            answer=weight
        return
    else:
        dfs(n+1,weight+N_arr[n],t_sum+N_arr[n])
        dfs(n+1,weight,t_sum+N_arr[n] )

answer=0

C,N = map(int,input().split())
N_arr=[]

for i in range(N):
    tmp=int(input())
    N_arr.append(tmp)
total= sum(N_arr)
dfs(0,0,0)
print(answer)