import sys
#sys.stdin=open("input.txt", "r")

def dfs(cnt):
    global n,m,tmp_arr,ans_arr,dp_arr
    if cnt == m:
        if set(dp_arr) not in tmp_arr:
            tmp=dp_arr[:]
            ans_arr.append(tmp)
            tmp_arr.append(set(dp_arr))
        return
    else:
        for i in range(1,n+1):
            if i not in dp_arr:
                dp_arr[cnt]=i
                dfs(cnt+1)
                dp_arr[cnt]=0
n,m=map(int,input().split())
#set_arr1={1,2,3}
#set_arr2={2,1,3}
dp_arr=[0]*m
tmp_arr=[]
ans_arr=[]

dfs(0)

for i in ans_arr:
    for j in i :
        print(j,end=' ')
    print("")
print(len(ans_arr))

#tmp_arr.append(set_arr1)


#if set_arr2 in tmp_arr:
#    print("있다")

#print(tmp_arr)
#set_arr.add()
#set_arr.add()

#print())