def plus_num(start,end):
    su=  (end * (end+1))//2 - ((start-1) * (start))//2
    return su

def solution(n):
    answer = 0
    start=1
    end=1
    while True :
        if (start == n and end == n) or end > n or start > n:
            answer+=1
            break
        else :
            if plus_num(start,end) < n:
                end+=1
            elif plus_num(start,end) > n:
                start+=1
            elif plus_num(start,end) == n :
                answer+=1
                start+=1
                end+=1
    return answer