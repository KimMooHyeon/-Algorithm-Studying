def solution(keymap, targets):
    answer = []
    keyHash = {}
    for i in range(0,len(keymap)):
        for j in range(0,len(keymap[i])):
            if keymap[i][j] in keyHash :
                if keyHash[keymap[i][j]]>j+1:
                    keyHash[keymap[i][j]]=j+1
            else:
                keyHash[keymap[i][j]]=j+1
    for target in targets:
        num = 0
        flag = False
        for alpha in target:
            if alpha not in keyHash:
                flag=True
                break
            else:
                num+=keyHash[alpha]
        if flag :
            answer.append(-1)
        else :
            answer.append(num)
                
    return answer