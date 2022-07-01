import heapq
def solution(n, works):
    answer = 0
    #야근 피로도는 야근을 시작한 시점에서, 남은 일의 작업량을 제곱하여 더함
    #N시간동안 야근 피로도 최소화 하도록 일하기
    # 1시간동안 작업량 1만큼 처리
    # N은 퇴근까지 남은 시간
    n_work=[]
    for i in works:
        heapq.heappush(n_work,-i)
    tmp=-heapq.heappop(n_work)
    tmp-=1
    heapq.heappush(n_work,-tmp)
    
    for i in range(n-1):
        tmp=-heapq.heappop(n_work)
        tmp-=1
        heapq.heappush(n_work,-tmp)
    print(n_work)
    for i in n_work:
        if -i<0:
            continue
        else:
            answer+= i*i
        
    return answer