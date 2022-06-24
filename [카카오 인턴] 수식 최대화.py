from itertools import permutations

def solution(expression):
    answer=0
    operator=['+','*','-']
    operator_arr=list(map(list,permutations(operator)))
    
    for i in operator_arr:
        first= list(expression.split(i[0]))
        second=[]
        for j in first:
            second.append(list(map(str,(list(map(eval,list(j.split(i[1]))))))))
        second_arr=[]
        for k in second :
            tmp=str(eval(i[1].join(k)))
            second_arr.append(tmp)
        if answer < abs(eval(i[0].join(second_arr))) :
            answer=abs(eval(i[0].join(second_arr)))
    return answer