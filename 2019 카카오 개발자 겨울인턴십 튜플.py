def solution(s):
    tmp=list(s.split('},{'))
    s_arr=[]
    for i in tmp :
        s_arr.append(((i.replace('{{','')).replace('}}','')).replace("'",''))
    s_arr.sort(key=len)

    answer = []
    
    for j in s_arr :
        tmp_arr=list(j.split(','))
        for k in tmp_arr:
            if int(k) not in answer:
                answer.append(int(k))
    
  
    return answer