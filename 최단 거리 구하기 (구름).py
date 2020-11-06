import sys

user_input = int(sys.stdin.readline())
ans_list = []

map_list = [list(map(int, sys.stdin.readline().split())) for _ in range(user_input)]
visit = [[False for _ in range(user_input)] for _ in range(user_input)]


def dfs(x, y, number):
    global map_list
    global visit
    global user_input
    visit[x][y] = True
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]
    if x == user_input - 1 and y == user_input - 1:
        ans_list.append(number)
    else:
        for i in range(4):
            if x + dx[i] >= 0 and x + dx[i] < user_input and y + dy[i] >= 0 and y + dy[i] < user_input:
                if visit[x + dx[i]][y + dy[i]] == False and map_list[x + dx[i]][y + dy[i]] == 1:
                    number += 1
                    dfs(x + dx[i], y + dy[i], number)
                    visit[x + dx[i]][y + dy[i]] = False
                    number -= 1


dfs(0, 0, 0)
print(min(ans_list) + 1)

