from _collections import deque
def solution(progresses, speeds):
    answer = []
    pro_list=deque()
    speed_list=deque()
    for i in progresses :
        pro_list.append(i)
    for i in speeds:
        speed_list.append(i)
    while pro_list :
        num=0
        ans_num=0
        while pro_list[0] <100 :
            pro_list[0]+=speed_list[0]
            num+=1
        ans_num+=1
        pro_list.popleft()
        speed_list.popleft()
        out_num=0
        for i in range(len(pro_list)):
            pro_list[i]+=speed_list[i]*num
        for i in range(len(pro_list)):
            if pro_list[i]>=100 :
                ans_num+=1
                out_num+=1
            else :
                break
        for i in range(out_num):
            pro_list.popleft()
            speed_list.popleft()
        answer.append(ans_num)
    return answer