visit = []
main_computers = []


def solution(n, computers):
    cnt = n
    answer = 0
    global main_computers
    global visit
    visit = [0] * n
    main_computers = computers

    def dfs(computers, n, cnt):
        global visit

        if visit[n] == 0:
            visit[n] = 1
            for i in range(cnt):
                if computers[i] == 1 and i != n:
                    dfs(main_computers[i], i, cnt)

    for i in range(n):
        # 방문한 컴퓨터라면 skip
        if visit[i] == 0:
            dfs(computers[i], i, cnt)
            answer += 1

    return answer

