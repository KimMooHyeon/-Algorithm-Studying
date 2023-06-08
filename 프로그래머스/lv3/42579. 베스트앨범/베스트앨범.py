def solution(genres, plays):
    checkHash={}
    checkNum={}
    answer = []
    sortList =[]
    for i,v in enumerate(genres):
        sortList.append([i,plays[i]])
        if v not in checkHash :
            checkHash[v] =plays[i]
        else:
            checkHash[v]+=plays[i]
    sortList.sort(key=lambda x : (-checkHash[genres[x[0]]],-x[1],x[0]))
    for i in sortList :
        if genres[i[0]] not in checkNum :
            checkNum[genres[i[0]]]=1
            answer.append(i[0])
        else:
            if checkNum[genres[i[0]]]==1:
                checkNum[genres[i[0]]]=2
                answer.append(i[0])
                
    return answer