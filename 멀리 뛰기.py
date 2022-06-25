def dfs(num) :
    global answer
    global number
    
    if num>number :
        return    
    elif num == number :
        answer+=1
        return
    else:
        for i in range(1,3):
            dfs(num+i)
        
        

def solution(n):
    global answer
    global number 
    number = n 
    answer = 0
    dp=[0]*2000
    dp[1]=1
    dp[2]=2
    for i in range(3,n+1):

        dp[i]=dp[i-1]+dp[i-2]

    return dp[n]%1234567