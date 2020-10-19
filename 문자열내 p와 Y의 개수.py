def solution(s):
    answer = True
    p_number = 0
    y_number = 0

    for i in s:
        if i == 'p' or i == 'P':
            p_number += 1
        elif i == 'y' or i == 'Y':
            y_number += 1
    if y_number == p_number:
        return True
    else:
        return False

    return True