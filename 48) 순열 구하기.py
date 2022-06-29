import sys
#sys.stdin=open("input.txt", "r")

#n = int(input())
answer_arr=[]
def dfs(num,dfs_arr2):
    if num == m :
        tmp_arr=dfs_arr2[:]
        answer_arr.append(tmp_arr)
        #print(dfs_arr2)
        return 
    else :
        for i in range(1,n+1):
            if i not in dfs_arr2 :
                tmp= i 
                dfs_arr2[num]=tmp
                dfs(num+1,dfs_arr2)
                dfs_arr2[num]=0

n,m=map(int,input().split())
dfs_arr=[0]*m

dfs(0,dfs_arr)

for i in answer_arr :
    for j in i :
        print(j,end = ' ')
    print()
print(len(answer_arr))