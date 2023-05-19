import sys
import heapq

# 수빈 n
# 동생 k
# 수빈이는 1초후 x-1, x+1, 순간이동은 1초후 2*X
# 동생은 이동시 가속, 동생은 이동한 거리보다 1을 더 한 만큼 이동
answer = -1
n, k = map(int, sys.stdin.readline().split(" "))

dpEvenCheck = [True for _ in range(500001)]
dpOddCheck = [True for _ in range(500001)]

pq = []

# 걸린 시간, 현재 위치
heapq.heappush(pq, (0, n, k))
while len(pq) > 0:
    curN = heapq.heappop(pq)
    if curN[0] % 2 == 0:
        if not dpEvenCheck[curN[1]]:
            continue
        dpEvenCheck[curN[1]] = False
    else:
        if not dpOddCheck[curN[1]]:
            continue
        dpOddCheck[curN[1]] = False

    if curN[2] > 500000:
        break
    # 동생위치랑 같다면
    if curN[1] == curN[2] or (curN[0] % 2 == 0 and not dpEvenCheck[curN[2]]) or (
            curN[0] % 2 == 1 and not dpOddCheck[curN[2]]):
        answer = curN[0]
        break

    if curN[0] % 2 == 0:
        if curN[1] + 1 <= 500000 and dpOddCheck[curN[1] + 1] and curN[2] + (curN[0] + 1) <= 500000:
            heapq.heappush(pq, (curN[0] + 1, curN[1] + 1, curN[2] + curN[0] + 1))

        if curN[1] * 2 <= 500000 and dpOddCheck[curN[1] * 2] and curN[2] + (curN[0] + 1) <= 500000:
            heapq.heappush(pq, (curN[0] + 1, curN[1] * 2, curN[2] + curN[0] + 1))

        if 0 <= curN[1] - 1 <= 500000 and dpOddCheck[curN[1] - 1] and curN[2] + (curN[0] + 1) <= 500000:
            heapq.heappush(pq, (curN[0] + 1, curN[1] - 1, curN[2] + curN[0] + 1))
    else:

        if curN[1] + 1 <= 500000 and dpEvenCheck[curN[1] + 1] and curN[2] + (curN[0] + 1) <= 500000:
            heapq.heappush(pq, (curN[0] + 1, curN[1] + 1, curN[2] + curN[0] + 1))

        if curN[1] * 2 <= 500000 and dpEvenCheck[curN[1] * 2] and curN[2] + (curN[0] + 1) <= 500000:
            heapq.heappush(pq, (curN[0] + 1, curN[1] * 2, curN[2] + curN[0] + 1))

        if 0 <= curN[1] - 1 <= 500000 and dpEvenCheck[curN[1] - 1] and curN[2] + (curN[0] + 1) <= 500000:
            heapq.heappush(pq, (curN[0] + 1, curN[1] - 1, curN[2] + curN[0] + 1))

print(answer)
