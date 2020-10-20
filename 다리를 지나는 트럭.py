from collections import deque


def solution(bridge_length, weight, truck_weights):
    answer = 1
    check = 0
    wait_queue = deque()
    going_queue = deque()
    now_weight = 0

    for i in truck_weights:
        wait_queue.append(i)

    while True:
        #print(str(answer) + "= answer")

        #print(going_queue)
        if wait_queue:
            if now_weight + wait_queue[0] <= weight:
                w = wait_queue.popleft()
                now_weight += w
                going_queue.append([answer, w])
        #print('answer-going_queue[0][0]='+str(answer-going_queue[0][0]))




        if ((answer-going_queue[0][0] == bridge_length) and answer != 0 ) :
            a, wei = going_queue.popleft()
            check += 1
            now_weight -= wei
            if wait_queue:
                if now_weight + wait_queue[0] <= weight:
                    w = wait_queue.popleft()
                    now_weight += w
                    going_queue.append([answer, w])




        if check == len(truck_weights):
        #    print("break")
            break
       # print(going_queue)
       # print(wait_queue)


        if wait_queue :
           # print("d")
            if now_weight + wait_queue[0] > weight:
                answer = bridge_length + going_queue[0][0]
              #  print(answer)
            else:
                answer += 1
        else: answer = bridge_length + going_queue[0][0]


        print(answer)
    return answer
print(solution(	10000,100, [7,4,5,6,100]))