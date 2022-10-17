import heapq
import sys

heap_list=[]
N = int(sys.stdin.readline().rstrip())

for _ in range (N):
    num=int(sys.stdin.readline().rstrip())
    if num !=0 :
        heapq.heappush(heap_list,-num)
    else:
        if len(heap_list)==0 :
            print(0)
        else:
            max_num = -(heapq.heappop(heap_list))
            print(max_num)

