def solution(people, limit):
    answer = 0
    start = 0
    end = len(people) - 1
    people.sort(reverse=True)

    while start <= end:
        if start == end:
            answer += 1
            break
        if people[start] + people[end] <= limit:
            answer += 1
            start += 1
            end -= 1
        else:
            answer += 1
            start += 1

    return answer