def solution(n, stations, w):
    answer = 0
    temp = 2*w+1
    start = 1
    end=0
    for i in stations:
        end = i-w-1
        print(f'{start} {end}')
        if end < start :
            start =i+w+1
        else:
            num = end-start+1
            if num//temp == 0:
                answer+=1
            else:
                if num%temp == 0 :
                    answer+=num//temp
                else:
                    answer += num//temp+1
            start =i+w+1

    if start<=n:
        end = n
        num = end-start+1
        if num//temp == 0:
            answer+=1
        else:
            if num%temp == 0 :
                answer+=num//temp
            else:
                answer += num//temp+1
    return answer