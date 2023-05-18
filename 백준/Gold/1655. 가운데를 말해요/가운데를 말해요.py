import sys
from queue import PriorityQueue
import heapq

# 길이는 L이고, K개의 위치에서만 자를수 있다.
# 통나무는 최대 C번 자를 수 있다.
# 가장 긴 조작을 자게 만들고, 그 길이를 출력
minQueue = []
maxQueue = []
n = int(sys.stdin.readline())
for i in range(n):
    number = int(sys.stdin.readline())
    if len(maxQueue) == 0:
        print(number)
        heapq.heappush(maxQueue,-number)
    else:
        if len(maxQueue) > len(minQueue):
            curStackNum = -maxQueue[0]
            if number > curStackNum:
                heapq.heappush(minQueue,number)
                print(curStackNum)
            else:
                heapq.heappush(maxQueue, -number)
                heapq.heappush(minQueue, -heapq.heappop(maxQueue))
                print(-maxQueue[0])
        else:
            maxNum = minQueue[0]
            if maxNum > number:
                heapq.heappush(maxQueue, -number)
                print(-maxQueue[0])
            else:
                heapq.heappop(minQueue)
                heapq.heappush(maxQueue, -maxNum)
                heapq.heappush(minQueue, number)
                print(-maxQueue[0])
