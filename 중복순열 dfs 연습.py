import sys
sys.stdin=open("input.txt", "r")

n,m=map(int,input().split())

def permutaton(number):
    global dfs_arr
    dfs_arr=[0]*number
    dfs(0,number)

dfs_arr = []
answer_arr=[]
def dfs(num,m):
    global dfs_arr
    global n
    global answer_arr
    if num == m:
        tmp=dfs_arr[:]
        answer_arr.append(tmp)
    
    else:
        for i in range(1,n+1):
            dfs_arr[num]=i
            dfs(num+1,m)


permutaton(m)
for i in answer_arr :
    for j in i :
        print(j, end = ' ')
    print()
   
print(len(answer_arr))
