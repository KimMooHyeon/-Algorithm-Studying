from collections import deque
N, K = map(int, input().split())
visited = [False] * 100001

def bfs(v):
    count = 0
    queue = deque([[v, count]])

    while queue:
        v = queue.popleft()
        e = v[0]
        count = v[1]
        if not visited[e]:
            visited[e] = True
            if e == K:
                return count
            count += 1
            if (e * 2) <= 100000:
                queue.append([e * 2, count])
            if (e + 1) <= 100000:
                queue.append([e + 1, count])
            if (e - 1) >= 0:
                queue.append([e - 1, count])
    return count
print(bfs(N))