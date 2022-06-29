import sys
#sys.stdin=open("input.txt", "r")

def dfs(level,ans_arr,index):
    # break 변수
    global check_flag
    global answer
    if check_flag:
        return
    # 줄 수
    global n 
    # 마지막 줄에 숫자
    global m
    # 답 출력용 배열`
    global per_arr

    # 줄 수가 마지막 일경우 숫자 일치 여부 
    if level == n :
        if m == ans_arr[0] :
            check_flag=True
            #print(ans_arr,per_arr[index],index)
            answer=index
            
        return
    else:
        tmp_arr=[]
        for i in range(0,len(ans_arr)-1):
      
            tmp_arr.append(ans_arr[i]+ans_arr[i+1])
        dfs(level+1,tmp_arr,index)


def permutation(num):
    global n
    global dp_arr 
    global per_arr
    global answer
    if answer != -1 :
        return
    if num == n :
        tmp= dp_arr[:]
        per_arr.append(tmp)
        dfs(1,tmp,len(per_arr)-1)
        return
    for i in range(1,n+1):
        if i in dp_arr:
            continue
        dp_arr[num]=i
        permutation(num+1)
        dp_arr[num]=0


n,m=map(int,input().split())

#dfs(0)
per_arr=[]
dp_arr=[0]*n

check_flag=False
answer=-1
#print(per_arr)
permutation(0)
print(" ".join(list(map(str,per_arr[answer]))))