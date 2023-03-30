def solution(name, yearning, photo):
    answer = []
    hashScore = {}
    for i in range(0,len(name)) :
        hashScore[name[i]]=yearning[i]
    print(hashScore)
    for photoList in photo:
        num = 0 
        for onePhoto in photoList:
            if onePhoto in hashScore:
                num+=hashScore[onePhoto]
        answer.append(num)
    return answer