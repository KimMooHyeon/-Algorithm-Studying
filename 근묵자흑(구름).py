import sys

N, K = map(int, sys.stdin.readline().split())
num_list = list(map(int, sys.stdin.readline().split()))
min_index = num_list.index(min(num_list))
visit = [False for _ in range(N)]
visit[min_index] = True
ans = 0
if N <= K:
    print(1)
else:
    while N - 1 > 0:
        ans += 1
        N -= (K - 1)
print(ans)
