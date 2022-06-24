def solution(s):
    answer = ''
    answer_arr=[]
    ans_arr=list(map(str,s.split(' ')))
    print(ans_arr)
    for i in ans_arr:
        if len(i)<1:
            answer_arr.append(" ")
            continue
        if 'a'<=i[0]<='z':
            answer_arr.append(i.replace(i[0],i[0].upper(),1))
        else:
            answer_arr.append(i)

    for j in range(len(answer_arr)):
        if answer_arr[j]==" ":
            if j == (len(answer_arr)-1):
                continue
            answer+=(" ")
            continue
            
        for k in range(0,len(answer_arr[j])):
            if k==0:
                answer+=(answer_arr[j][k])
            else:
                if 'A'<=answer_arr[j][k]<='Z':
                    answer+=(answer_arr[j][k].lower())
                else:
                    answer+=(answer_arr[j][k])
        if j == (len(answer_arr)-1):
            continue
        answer+=" "
    return answer