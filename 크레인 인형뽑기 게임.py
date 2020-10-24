from _collections import deque


def solution(board, moves):
    answer = 0
    map_list = []
    for i in range(len(board)):
        map_list.append(deque())

    for i in range(len(board)):
        for j in range(len(board)):
            if board[i][j] != 0:
                map_list[j].append(board[i][j])
    answer_list = []
    for i in moves:
        a = i - 1
        if map_list[a]:
            answer_list.append(map_list[a].popleft())
            if len(answer_list) > 1:
                if answer_list[-1] == answer_list[-2]:
                    answer += 2
                    del answer_list[-1]
                    del answer_list[-1]

    print(answer_list)

    return answer