def solution(participant, completion):
    answer = ''
    player_list = {}
    finish_player_list = {}

    for i in participant:
        finish_player_list[i] = 0
        player_list[i] = 0

    for i in participant:
        player_list[i] += 1

    for i in completion:
        finish_player_list[i] = 0
    for i in completion:
        finish_player_list[i] += 1

    for i in participant:
        if finish_player_list[i] != player_list[i]:
            answer = i

    return answer
