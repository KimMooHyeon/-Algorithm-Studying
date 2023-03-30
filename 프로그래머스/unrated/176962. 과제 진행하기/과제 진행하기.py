from collections import deque


def changeTime(timeString):
    time = list(map(int, timeString.split(":")))
    return time[0] * 60 + time[1]


def solution(plans):
    answer = []
    planList = []
    planQueue = deque()
    waitQueue = deque()
    for i in plans:
        planList.append([i[0], changeTime(i[1]), int(i[2])])
    planList.sort(key=lambda x: x[1])

    for i in planList:
        planQueue.append(i)

    nowTime = planList[0][1]
    curJob = []
    
    while len(answer) < len(plans):
        if len(planQueue) == 0:
            if curJob:
                answer.append(curJob[0])
            while len(waitQueue) != 0:
                answer.append(waitQueue.pop()[0])
            break
        if nowTime == planQueue[0][1]:
            if curJob:
                curJob[2] -= 1
                if curJob[2] == 0:
                    name = curJob[0]
                    curJob.clear()
                    answer.append(name)
                else:
                    waitQueue.append(curJob)
            elif len(waitQueue) > 0:
                waitQueue[-1][2] -= 1
                if waitQueue[-1][2] == 0:
                    answer.append(waitQueue.pop()[0])
            curJob = planQueue.popleft()
        elif curJob:
            curJob[2] -= 1
            if curJob[2] == 0:
                answer.append(curJob[0])
                curJob = None
        elif len(waitQueue) > 0:
            waitQueue[-1][2] -= 1
            if waitQueue[-1][2] == 0:
                answer.append(waitQueue.pop()[0])
        nowTime += 1
        
    return answer
