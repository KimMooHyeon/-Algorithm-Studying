from _collections import deque


def solution(bridge_length, weight, truck_weights):
    answer = 0
    finish_list = deque()
    ing_list = deque()
    remain_list = deque()
    truck_sum = len(truck_weights)

    for i in truck_weights:
        remain_list.append(i)

    ing_weight = 0

    while len(finish_list) != truck_sum:
        # print(finish_list)
        # print(ing_list)
        # print (remain_list)
        check = 0
        answer += 1
        if len(remain_list) >= 1:
            if ing_weight + remain_list[0] <= weight:
                now_truck = remain_list.popleft()
                ing_weight += now_truck
                ing_list.append([now_truck, answer])
                check = 1
        check2 = 0
        for i in ing_list:
            if check2 == 1:
                break
            check2 += 1
            if answer - i[1] == bridge_length:
                out = ing_list.popleft()
                ing_weight -= out[0]
                finish_list.append(out[0])
                if len(remain_list) >= 1:
                    if ing_weight + remain_list[0] <= weight and check == 0:
                        now_truck = remain_list.popleft()
                        ing_weight += now_truck
                        ing_list.append([now_truck, answer])
                break
            else:
                break

    return answer