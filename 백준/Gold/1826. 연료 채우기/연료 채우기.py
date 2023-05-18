import sys
from queue import PriorityQueue

# 주유소에서 멈추는 횟수, 도착하지 못하면 -1 출력
# 1km 마다 1L의 연료가 새나어나간다.
# 주유소의 개수
answer = 0
n = int(sys.stdin.readline())
energyHash = {}
queue = PriorityQueue()
for i in range(n):
    # 시작위치에서 주유소까지 거리, 채울 수 있는 연료의 양
    a, b = map(int, sys.stdin.readline().split(" "))
    energyHash[a] = b
# 마을까지의 거리, 트럭에 원래 있던 연료의 양
L, P = map(int, sys.stdin.readline().split(" "))
failFlag = False
for i in range(1, L + 1):
    if P == 0:
        if queue.qsize() > 0:
            P += -queue.get()
            answer += 1
        else:
            failFlag = True
            break
    if i in energyHash:
        queue.put(-energyHash[i])
    P -= 1

if failFlag:
    print(-1)
else:
    print(answer)
