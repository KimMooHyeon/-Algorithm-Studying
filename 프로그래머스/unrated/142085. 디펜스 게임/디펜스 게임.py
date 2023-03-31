import heapq

def solution(n, k, enemy):
    answer = 0
    number = n 
    heap = []
    for i in enemy:
        if number-i >=0 :
            number-=i
            answer+=1
            heapq.heappush(heap,-i)
        elif k > 0:
            answer+=1
            k-=1
            if len(heap) == 0 :
                continue
                    
            num = -heapq.heappop(heap)
                
            if num > i:
                number-=i
                number+=num
                heapq.heappush(heap,-i)
            else:
                heapq.heappush(heap,-num)
        else :
            break
  
    return answer