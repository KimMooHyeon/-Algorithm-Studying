def solution(n, words):
    answer = []
    cnt_his={}
    for i in range (1,1+n):
        cnt_his[i]=0
    words_history=[]
    words_history.append(words[0])
    cnt=1
    cnt_num=1
    cnt_his[cnt]+=1
    while cnt_num<len(words):
        cnt_num+=1
        cnt+=1
        
        if cnt>n:
            cnt-=n
        cnt_his[cnt]+=1
        word=words[cnt_num-1]
        if word in words_history:
            print(words_history)
            print(word)
            answer.append(cnt)
            answer.append(cnt_his[cnt])
            return answer
            
        else:
            if word[0] != words[cnt_num-2][-1]:
                print(words_history)
                print(word)
                print(cnt_num)
                answer.append(cnt)
                answer.append(cnt_his[cnt])
                return answer
            else:
                words_history.append(word)
    if answer:
        pass
    else:
        return [0,0]