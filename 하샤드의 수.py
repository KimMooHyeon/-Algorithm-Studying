def solution(x):
    answer = False
    now_sum=0
    now_x=x
    
    while True:
        if x<10 :
            now_sum+=x
            break
        else:
            now_sum+=x%10
            x=x//10
            
    if now_x%now_sum ==0:
        answer = True
    print(now_sum)
            
            
    
    return answer