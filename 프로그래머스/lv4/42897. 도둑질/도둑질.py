def solution(money):
    answer = 0
    dpStart = [0 for i in range(len(money))]
    dpNotStart = [0 for i in range(len(money))]
    num=0
    while num<len(money)-1:
        if num <= 1 :
            dpStart[num]=money[num]
        elif num == 2 :
            dpStart[num]=money[num]+dpStart[num-2]
        else:
            dpStart[num]=money[num]+max(dpStart[num-2],dpStart[num-3])
        num+=1
    num=0
    while num<len(money):
        if num <= 1 :
            if num ==0:
                pass
            else:
                dpNotStart[num]=money[num]
        elif num == 2 :
            dpNotStart[num]=money[num]+dpNotStart[num-2]
        else:
            dpNotStart[num]=money[num]+max(dpNotStart[num-2],dpNotStart[num-3])
        num+=1
            
            
            
            
    return max(max(dpStart),max(dpNotStart))