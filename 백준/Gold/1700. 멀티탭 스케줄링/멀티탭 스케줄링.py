from queue import PriorityQueue


def dfs(index, n, k, kList, changeNum, nowSize, choiceList):
    global answer
    global hash
    global curQueue
    if index == k:
        return
    else:

        curData = kList[index]
        curDataIndex= -9999
        if hash[kList[index]].qsize()>0:
            curDataIndex = -hash[kList[index]].get()

        if kList[index] in choiceList:
         #   print(f'{kList[index]} 는 리스트에 존재')
            temp = []
            while curQueue.qsize()>0:
                nowQueue = curQueue.get()
                if nowQueue[1] == kList[index]:
                  #  print(f'{kList[index]} 찾음 {nowQueue[0]} size {hash[kList[index]].qsize()}')
                    temp.append((curDataIndex,nowQueue[1]))
                    break
                else:
                    temp.append(nowQueue)
            for i in temp:
                curQueue.put(i)
            dfs(index + 1, n, k, kList, changeNum, nowSize, choiceList)
        else:
            if nowSize < n:
                choiceList[kList[index]] = True
                curQueue.put((curDataIndex, curData))
                dfs(index + 1, n, k, kList, changeNum, nowSize + 1, choiceList)
            else:

                answer += 1
                #print("ㅁ 변경 ㅁ")

                temp = curQueue.get()

                del choiceList[temp[1]]
                choiceList[kList[index]] = True


                curQueue.put((curDataIndex, curData))
                #print(choiceList)
                dfs(index + 1, n, k, kList, changeNum, nowSize + 1, choiceList)


# 멀티탭 구멍의 개수 N과 전기 용품의 총 사용 횟수 K
n, k = map(int, input().split(" "))
kList = list(map(int, input().split(" ")))
hash = {}
answer = 0
curQueue = PriorityQueue()

for i in range(k):
    if kList[i] in hash:
        hash[kList[i]].put(i)
    else:
        hash[kList[i]] = PriorityQueue()


dfs(0, n, k, kList, 0, 0, {})
print(answer)
