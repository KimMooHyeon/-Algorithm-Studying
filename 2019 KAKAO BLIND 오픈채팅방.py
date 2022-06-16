def solution(record):
    answer = []
    answer_res=[]
    user_id_dic={}
    a="aavb"
    a=a.replace('aa','cc')
    print(a)
    for i in record :
        act=i.split()[0]
        user_id=i.split()[1]
        if act == 'Enter':
            user_id_dic[i.split()[1]]=i.split()[2]
            answer_res.append(("님이 들어왔습니다.",user_id))
        elif act == 'Leave':
            answer_res.append(("님이 나갔습니다.",user_id))
        elif act == 'Change':
            user_id_dic[i.split()[1]]=i.split()[2]
    for j in answer_res:
        answer.append(user_id_dic[j[1]]+j[0])
 

    return answer