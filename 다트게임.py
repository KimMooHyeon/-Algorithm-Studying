def solution(dartResult):
    # S는 1제곱 ,D는 2제곱 , T는 3제곱
    answer = 0
    score_list = []
    for i in range(len(dartResult)):
        if (ord(dartResult[i]) - 48) >= 0 and (ord(dartResult[i]) - 48) <= 10:
            if i - 1 >= 0:
                if ord(dartResult[i]) - 48 == 0 and score_list[-1][0] == i - 1:
                    score_list[-1][1] = 10
                else:
                    score_list.append([i, ord(dartResult[i]) - 48])
            else:
                score_list.append([i, ord(dartResult[i]) - 48])

        if dartResult[i] == 'D':
            score_list[-1][1] **= 2

        elif dartResult[i] == 'T':
            score_list[-1][1] **= 3

        if dartResult[i] == '*':
            score_list[-1][1] *= 2
            if len(score_list) >= 2:
                score_list[-2][1] *= 2
        if dartResult[i] == '#':
            score_list[-1][1] *= -1

    for i in score_list:
        answer += i[1]
    # answer= sum(score_list[][1] )

    return answer