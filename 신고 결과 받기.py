def solution(id_list, report, k):
    answer = []
    list_arr=[[] for _ in range(0,len(id_list))]
    dic_arr={}
    police_num={}
    
    for i in range(0,len(id_list)):
        list_arr[i].append(id_list[i])
        dic_arr[id_list[i]]=i
        

    for i in report:
        N,K=map(str,i.split(' '))
        if K not in list_arr[dic_arr[N]]:
            list_arr[dic_arr[N]].append(K)
            if K in police_num :
                police_num[K]+=1
            else:
                police_num[K]=1

    for i in range(0,len(list_arr)):
        cnt=0
        for j in range(1,len(list_arr[i])):
            if list_arr[i][j] in police_num :
                if police_num[list_arr[i][j]] >=k :
                    cnt+=1
        answer.append(cnt)

    return answer