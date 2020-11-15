def change_jinsu(num, jinsu):
    return_list = []
    if num == 0:
        return_list.append(0)
        return return_list

    while num != 0:
        n, remain = divmod(num, jinsu)
        if remain >= 10:
            return_list.append(chr(remain + 55))
        else:
            return_list.append(remain)
        num = n
    li = return_list
    li.reverse()
    return li


def solution(n, t, m, p):
    answer = ''
    an_list = []
    # print(ord('A')-55)
    # print(ord('F')-55)
    for i in range(t * m):
        jin_list = change_jinsu(i, n)
        for i, v in enumerate(jin_list):
            an_list.append(v)
    print(len(an_list))
    for _ in range(t):
        answer += str(an_list[p - 1])
        p += m

    return answer