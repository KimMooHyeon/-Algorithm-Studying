def solution(citations):
    answer = 0
    citations.sort()
    h = 1
    while(h < len(citations)):
        temp = len(citations) - h
        if(temp !=0 and citations[temp] >= h and citations[temp-1] <= h):
            answer = max(answer,h)
        h += 1
    if(answer == 0 and citations[0] >= h):
        answer = h
    return answer

