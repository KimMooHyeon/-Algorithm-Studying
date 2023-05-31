import heapq

def solution(A, B):
    answer = 0
    heapq.heapify(A)
    heapq.heapify(B)
    while len(A)!=0 and len(B)!=0:
        curA = heapq.heappop(A)
        curB = -1
        while curA >= curB :
            curB = heapq.heappop(B)
            if len(B)==0:
                break
        if curA < curB:
            answer+=1
    return answer