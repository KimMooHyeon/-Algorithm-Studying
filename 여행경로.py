tickets_lists=[]
check_list=[]
answer = []
answer2 = ['Z']

def solution(tickets):
    global finish_num
    global answer
    global answer2
    global check_list
    global tickets_lists
    tickets.sort()
    t_list=dict()
    for i in tickets:
        if i not in tickets_lists:
            tickets_lists.append(i)
    check_list= [False]*len(tickets_lists)
    def dfs(index):
        global answer
        global check_list
        global tickets_lists
        global answer2
        check_list[index]=True
        answer.append(tickets_lists[index][0])
        if False not in  check_list :
            answer.append(tickets_lists[index][1])
            if answer2 > answer:
                answer2=answer
        else:
            my=0
            for i,v in enumerate(tickets_lists):
                if check_list[i]==False and v[0] == tickets_lists[index][1]:
                    dfs(i)
                    my=1
            if my ==0:
                check_list[index]=False
                del answer[-1]

    for i,v in enumerate(tickets_lists):
        if v[0]=='ICN':
            check_list= [False]*len(tickets_lists)
            answer=[]
            dfs(i)
    return answer2