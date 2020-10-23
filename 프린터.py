from collections import deque


def solution(priorities, location):
    answer = 0
    check_start = 0
    print_queue = deque()

    for i in range(0, len(priorities)):
        print_queue.append([i, priorities[i]])

    while print_queue:
        check = 0
        b, a = print_queue.popleft()
        for i in range(0, len(print_queue)):
            if print_queue[i][1] > a:
                print_queue.append([b, a])
                check = 1
                break
        if check == 0:
            print(a)
            check_start += 1
            if b == location:
                answer = check_start
                break

    return answer