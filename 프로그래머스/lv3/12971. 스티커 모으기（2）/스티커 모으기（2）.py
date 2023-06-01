
def solution(sticker):
    if len(sticker) == 1 :
        return sticker[0]
    elif len(sticker) <= 3 :
        return max(sticker)
    answer =0
    dp = [0 for i in range(len(sticker))]
    dp[0] = sticker[0]
    dp[1] = sticker[1]
    dp[2] = sticker[2]+dp[0]
    for i in range(3,len(sticker)-1):
        dp[i]=max(dp[i-2],dp[i-3])+sticker[i]
    
    dpEnd = [0 for i in range(len(sticker))]
    dpEnd[0] =0
    dpEnd[1] = sticker[1]
    dpEnd[2] = sticker[2]
    for i in range(3,len(sticker)):
        dpEnd[i]=max(dpEnd[i-2],dpEnd[i-3])+sticker[i]

    return max(max(dp),max(dpEnd))