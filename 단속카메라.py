def solution(routes):
    routes.sort(key= lambda x : x[1])
    check_flag=[False]*len(routes)
    answer = 0
    check_vidio= -30001
    for i,v in enumerate(routes):
        if check_flag[i-1] ==True:
            continue
        else:
            if v[0] <= check_vidio <=v[1]:
                check_flag[i-1] =True
            else:
                answer+=1
                check_vidio=v[1]
    return answer