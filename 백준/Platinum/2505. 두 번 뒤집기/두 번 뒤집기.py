import sys
import heapq
import copy

# 왼쪽에서부터 가장 작게 순서가 아닌걸 해당 인덱스와 변경

n = int(sys.stdin.readline())
nList = list(map(int, sys.stdin.readline().split(" ")))
backList = copy.deepcopy(nList)
correct = [_ for _ in range(1, n + 1)]
firstList = []
secondList = []
for _ in range(2):
    findNum = -1
    if correct == nList:
        firstList.append([1, 1])
        continue
    for i in range(n):
        if findNum == -1:
            if nList[i] != i + 1:
                findNum = i
        else:
            if nList[i] == findNum + 1:
                temp = nList[findNum:i + 1]
                nList[findNum:i + 1] = temp[::-1]
                firstList.append([findNum + 1, i + 1])
                break
if nList == correct:
    for i in firstList:
        print(f'{i[0]} {i[1]}')
else:

    for _ in range(2):
        findNum = -1
        if correct == backList:
            print(f'{1} {1}')
            continue
        for i in range(n-1,-1,-1):
            if findNum == -1:
                if backList[i] != i + 1:
                    findNum = i+1
            else:
                if backList[i] == findNum:
                    temp = backList[i:findNum]
                    backList[i:findNum] = temp[::-1]
                    print(f'{i+1} {findNum}')
                    break

