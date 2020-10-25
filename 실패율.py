def solution(N, stages):
    answer = []
    stage_challege_list = [0 for _ in range(N)]
    stage_clear_list = [0 for _ in range(N)]
    false_persent_list = []
    for i in stages:
        if i == N + 1:
            for j in range(N):
                stage_clear_list[j] += 1
        else:
            stage_challege_list[i - 1] += 1
            for j in range(i - 1):
                stage_clear_list[j] += 1
    for i in range(N):
        sum_people = stage_clear_list[i] + stage_challege_list[i]
        if stage_challege_list[i] == 0 and stage_clear_list[i] == 0:
            false_persent_list.append([i, 0])
            continue
        false_persent = stage_challege_list[i] / sum_people
        false_persent_list.append((i, false_persent))

    print(false_persent_list)
    f = sorted(false_persent_list, key=lambda x: (-x[1], x[0]))
    for i in f:
        answer.append(i[0] + 1)

    return answer