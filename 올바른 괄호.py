def solution(s):
    answer = True
    ans_list = []
    check_num = 0
    for v in s:
        if v == ')':
            if len(ans_list) == 0:
                return False
            ch = True
            if ans_list[-1] == '(':
                ans_list.pop()
                ch = False
            if ch:
                return False
            check_num -= 1
        else:
            ans_list.append(v)
            check_num += 1
    if check_num == 0:
        return True
    else:
        return False

    return True