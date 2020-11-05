def check_min_cnt(target_name):
    now = ord('A')
    target = ord(target_name)
    return (min(abs(now - ord('A') + (ord('Z') - target) + 1), abs(now - target)))


def solution(name):
    answer = 0
    right_ans = 0
    left_ans = 0
    check_num = [False] * len(name)
    check_num2 = [False] * len(name)
    for i, v in enumerate(name):
        if v == 'A':
            check_num[i] = True
            check_num2[i] = True

    for i, v in enumerate(name):
        right_ans += check_min_cnt(v) + 1
        if False not in check_num:
            break

    check_num = [False] * len(name)
    for i in range(0, -len(name), -1):
        left_ans += check_min_cnt(name[i]) + 1
        check_num2[i] = True
        print(name[i])
        if False not in check_num2:
            break
    print(left_ans)
    print(right_ans)
    answer = min(left_ans - 1, right_ans - 1)
    return answer