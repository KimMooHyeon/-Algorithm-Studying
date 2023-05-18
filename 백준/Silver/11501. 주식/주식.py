import sys

from queue import PriorityQueue

tc = int(sys.stdin.readline())

# 1.리스트 처음부터 스택에 크거나 같은 값 index 넣기 하면서 max값 갱신
# 2.더 작은 값 나오면 다 pop 시키고 값 더하기
for _ in range(tc):
    n = int(sys.stdin.readline())
    nList = list(map(int, sys.stdin.readline().split(" ")))
    answer = 0
    numList = []
    curMaxNum = 0
    for i in range(n - 1, -1, -1):
        if len(numList)==0:
            numList.append([i, nList[i]])
            curMaxNum = nList[i]
        else:
            if nList[i]<curMaxNum:
                numList.append([i, nList[i]])
                if i == 0 :
                    while len(numList) > 0:
                        curNum = numList.pop()
                        answer += curMaxNum - curNum[1]

            else:
                while len(numList)>0 :
                    curNum = numList.pop()
                    answer+= curMaxNum-curNum[1]
                curMaxNum = nList[i]
                numList.append([i, nList[i]])
    print(answer)
