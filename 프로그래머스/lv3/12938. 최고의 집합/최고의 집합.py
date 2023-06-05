# 11
# 3 3 5
# 3 4 4
def solution(n, s):
    answer = []
    # n개 
    # 합이 s 
    nowN = n
    remainNum = s
    if n>s:
        return [-1]
    while nowN>0:
        # 4 = 8 // 2
        divideNum=remainNum//nowN
        # 8 = 11 % 3
        remainNum=remainNum-divideNum
        
        answer.append(divideNum)
        nowN-=1
    return answer