import sys
import heapq

# 최소힙에 index와 같이 저장

n, l = map(int, sys.stdin.readline().split(" "))
nList = list(map(int, sys.stdin.readline().split(" ")))
minHeap = []
for i in range(n):
    heapq.heappush(minHeap, (nList[i], i))
    if i < l:
        print(minHeap[0][0], end=" ")
    else:
        while minHeap[0][1] <i-l+1:
            heapq.heappop(minHeap)
        print(minHeap[0][0], end=" ")