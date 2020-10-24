def solution(answers):
    answer = []
    supo1_answer = 0
    supo2_answer = 0
    supo3_answer = 0

    supo1 = [1, 2, 3, 4, 5]
    supo2 = [2, 1, 2, 3, 2, 4, 2, 5]
    supo3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]

    for i in range(len(answers)):
        if supo1[i % 5] == answers[i]:
            supo1_answer += 1
        if supo2[i % 8] == answers[i]:
            supo2_answer += 1
        if supo3[i % 10] == answers[i]:
            supo3_answer += 1
    max_num = max(supo1_answer, supo2_answer, supo3_answer)
    if max_num == supo1_answer:
        answer.append(1)
    if max_num == supo2_answer:
        answer.append(2)
    if max_num == supo3_answer:
        answer.append(3)

    return answer