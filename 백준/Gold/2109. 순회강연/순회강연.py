import sys
from queue import PriorityQueue

n = int(sys.stdin.readline())
queue = PriorityQueue()
workingList = []

for i in range(n):
    price, day = map(int, sys.stdin.readline().split(" "))
    workingList.append([price, day])
workingList.sort(key=lambda x: x[1])

nowDay = 1
for working in workingList:

    if working[1] >= nowDay:
        queue.put(working[0])
        nowDay += 1
    else:
        if queue.qsize() > 0:
            popQueue = queue.get()
            if popQueue < working[0]:
                queue.put(working[0])
            else:
                queue.put(popQueue)
answer = 0
while queue.qsize() > 0:
    answer += (queue.get())
print(answer)
