def solution(orders, course):
    answer=[]
    menu_dic={}
    for i in course:
        for j in range(0,len(orders)):
            tmp=list(map(list,itertools.combinations(list(orders[j]), i)))
            for k in tmp :
                k.sort()
                menu_dic["".join(k)]=menu_dic.get("".join(k),0)+1
            #menu_dic[j]=menu_dic.get(j,0)+1
    real_arr=[]

    for key,value in menu_dic.items():
        if value>1:
            real_arr.append([value,key])
    real_arr.sort(reverse=True)
    max_num={}
    print(real_arr)
    for i in real_arr:
        if len(i[1]) in max_num :
            if max_num[len(i[1])] <= i[0]:
                answer.append(i[1])

        else:
            max_num[len(i[1])]=i[0]
            answer.append(i[1])
            
            
    answer.sort()
      
    return answer