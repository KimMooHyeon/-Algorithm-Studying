def solution(nums):
    answer = 0
    temp = set(nums)
    num = len(nums)//2
  
    if len(temp)>num:
        return (num)
    else:
        return (len(temp))
    return answer