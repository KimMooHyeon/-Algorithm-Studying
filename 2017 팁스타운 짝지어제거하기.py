def solution(s):
    answer = 1
    s_arr=[]
    res=[]
    for i in s :
        s_arr.append(i)

    while s_arr:
        s_pop=s_arr.pop()
        if res :
            if res[-1] == s_pop:
                res.pop()
            else:
                res.append(s_pop)     
        else:
            res.append(s_pop)
    if res :
        answer=0
    else:
        answer=1

    return answer