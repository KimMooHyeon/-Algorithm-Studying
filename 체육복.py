def solution(n, lost, reserve):
    answer = 0
    reserve_list = []
    student = [1 for _ in range(n)]
    for i in lost:
        student[int(i) - 1] = student[int(i) - 1] - 1
    for i in reserve:
        student[int(i) - 1] = student[int(i) - 1] + 1
        if student[int(i) - 1] == 2:
            reserve_list.append(int(i) - 1)
    print(reserve_list)
    for i in reserve_list:
        if i == 0 and student[1] == 0:
            student[0] -= 1
            student[1] += 1
        elif student[i - 1] == 0:

            student[i - 1] += 1
            student[i] -= 1
        elif i == n - 1:
            if student[i - 1] == 0:
                student[i - 1] += 1
                student[i] -= 1
        elif student[i + 1] == 0:

            student[i + 1] += 1
            student[i] -= 1

    for i in student:
        if i >= 1:
            answer += 1

    return answer