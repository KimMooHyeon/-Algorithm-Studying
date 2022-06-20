import sys

def dfs(num):
    global n
    global n_arr
    if num > n:
        for i in range(1,len(n_arr)):
            if n_arr[i]==1:
                print(i,end = ' ')
        print("")
        return
    n_arr[num]=1
    dfs(num+1)
    n_arr[num]=0
    dfs(num+1)
    

#sys.stdin=open("input.txt","rt")
n=int(input())
n_arr=[0]*(n+1)

dfs(1)



