import heapq


def solution(scoville, k):
    heapq.heapify(scoville)
    i = 0
    while scoville[0] < k:
        if len(scoville) > 1:
            heapq.heappush(scoville, heapq.heappop(scoville) + (heapq.heappop(scoville) * 2))
            i += 1
        else:
            return -1
    return i


# 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
"""  
def solution(scoville, K):
    answer = 0
    scoville.sort()
    check=0
    while check == 0 :
        if len(scoville)==1:
            if scoville[0]>=K:     
                return answer
                break
            else:
                answer = -1
                return answer

        if scoville[0] < K :
           # print(scoville[0])
            two_sum=scoville[0] + scoville[1]*2
            del scoville[0] 
            del scoville[0]
            if len(scoville)==0 :
                scoville.append(two_sum)
                answer+=1
                if len(scoville)==1:
                    if scoville[0]>=K:    
                        return answer
                    else:
                        answer = -1
                        return answer
            for i,v in enumerate(scoville) :
                if i == len(scoville)-1:
                    scoville.append(two_sum)
                 #   print("?")
                    answer+=1
                    break

                if two_sum <= v:
                    scoville.insert(i,two_sum)
                  #  print(scoville)
                    answer+=1
                    break
        else  :
            break

    return answer
"""