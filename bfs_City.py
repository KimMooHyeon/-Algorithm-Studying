from collections import deque

n,m,k,x = map(int,input().split())
gragh = [[] for i in range(n+1)]

for i in range(m):
    a,b = map(int,input().split())
    gragh[a].append(b)

visited=[False] * (n+1)
count = [0] * (n+1)
visited[x] = 1

def bfs(x):
    queue = deque()
    queue.append(x)
    while queue:
        startcity = queue.popleft()
        for i in range(len(gragh[startcity])):
            if visited[gragh[startcity][i]] == False :
                visited[gragh[startcity][i]] = True
                count[gragh[startcity][i]]= count[startcity]+1
                queue.append(gragh[startcity][i])
bfs(x)
for i in range (len(count)):
    if count[i]==k :
        print(i)
    if k not in count :
        print(-1)
        break