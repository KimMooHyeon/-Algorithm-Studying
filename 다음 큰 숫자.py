def chenge_two(n):
    answer_list = []
    i_cnt = 0
    i = 1
    while n > 0:
        i, rest = divmod(n, 2)
        if rest == 1:
            i_cnt += 1
        n = i
        answer_list.append(rest)
    return answer_list, i_cnt


def solution(n):
    answer = 0
    answer_list, i_cnt = chenge_two(n)
    while True:
        n += 1
        answer_list2, i_cnt2 = chenge_two(n)
        if i_cnt == i_cnt2:
            return n
            break

    return answer