def solution(clothes):
    answer = 1
    checkHash = {}
    for i in clothes :
        if i[1] not in checkHash:
            checkHash[i[1]]=[i[0]]
        else:
            checkHash[i[1]].append(i[0])
    for i,v in checkHash.items():
        answer*=(len(v)+1)

    return answer-1