import sys
#sys.stdin=open("input.txt","rt")

def dfs(num):
   
    global n_dic

    if num >= n:
        tmp=[]
        for key,value in n_dic.items():
            if value == 1 :
                tmp.append(int(key))
        dfs_arr.append(tmp)
        return
    n_dic[n_arr[num]]=1
    dfs(num+1)
    n_dic[n_arr[num]]=0
    dfs(num+1)

n=int(input())
n_dic={}
n_arr=list(input().split())

for a in n_arr :
    n_dic[a]=0

dfs_arr=[]
dfs(0)
check_flag=False

for i in range(1,len(dfs_arr)-1):
    for j in range(i+1,len(dfs_arr)):

      #and (set(dfs_arr[0])== (list(set(dfs_arr[i]) | set(dfs_arr[j]))) )
        if (([] == list(set(dfs_arr[i]) & set(dfs_arr[j]))) and  (sum(dfs_arr[i]) == sum(dfs_arr[j]))):
            dfs_arr[0].sort()
            tmp= dfs_arr[i]+dfs_arr[j]
            tmp.sort()
            if tmp == dfs_arr[0]:

                print("YES")
                check_flag=True
                break
    if check_flag :
        break
if check_flag :
    pass
else:
    print("NO")