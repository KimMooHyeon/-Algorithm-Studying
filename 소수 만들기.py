from itertools import combinations


def check_sosu(number):
    i = 3
    if number % 2 == 0:
        return False
    else:
        while i * i <= number:
            if number % i == 0:
                return False
            i += 1
        return True


def solution(nums):
    answer = 0
    ans_num = 0
    #  print(list(combinations(nums,3)))
    com_list = list(combinations(nums, 3))
    for i, v in enumerate(com_list):
        ans_num = 0
        for j in range(3):
            ans_num += v[j]
        if check_sosu(ans_num):
            print(ans_num)
            answer += 1
            print(answer)

    return answer