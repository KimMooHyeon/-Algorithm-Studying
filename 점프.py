import sys
from _collections import deque
N = int(sys.stdin.readline())
game_map= [list(map(int,sys.stdin.readline().split())) for  i in range(int(N))]
#visit= [[False] * N for  i in range(int(N))]
dp_list= [[0] * N for  i in range(int(N))]
answer=0
dp_list[game_map[0][0]][0]=1
dp_list[0][game_map[0][0]]=1
""" 
def dfs (x,y) :
    global game_map
    global N
    global answer
    global dp_list


    if x == N-1 and y == N-1 :
        return

    if game_map[x][y] == 0  :
        pass
    else:
        if x + game_map[x][y] <N :
            dp_list[x + game_map[x][y]][y] += dp_list[x][y]
            dfs(x + game_map[x][y] , y)
        if y + game_map[x][y] <N :
            dp_list[x][y + game_map[x][y]] += dp_list[x][y]
            dfs(x,y+game_map[x][y])
"""

for i in range(N):
    for j in range(N):
        if  game_map[i][j] == 0 :
            continue
        if j + game_map[i][j] < N :
            dp_list[i][j + game_map[i][j]] += dp_list[i][j]
        if i + game_map[i][j] < N:
            dp_list[i + game_map[i][j]][j] += dp_list[i][j]

print(dp_list[N-1][N-1])