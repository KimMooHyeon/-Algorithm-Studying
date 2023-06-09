def solution(msg):
    msgList = list(msg)
    answer = []
    hash={}
    hashNum = 27
    num=1
    for i in range(65,91):
        hash[chr(i)]=num
        num+=1
    curIndex=0
    
    while curIndex < len(msgList):
        curStr = msgList[curIndex]
        addNum = 0
        while curStr in hash:
            addNum = hash[curStr]
            curIndex+=1
            if curIndex>=len(msgList) :
                break
            curStr+=msgList[curIndex]
        answer.append(addNum)
        hash[curStr] =hashNum
        hashNum+=1
        
    return answer