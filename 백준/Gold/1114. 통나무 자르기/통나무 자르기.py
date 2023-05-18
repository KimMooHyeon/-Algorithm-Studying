import sys
from queue import PriorityQueue

# 길이는 L이고, K개의 위치에서만 자를수 있다.
# 통나무는 최대 C번 자를 수 있다.
# 가장 긴 조작을 자게 만들고, 그 길이를 출력
queue = PriorityQueue()
L, K, C = map(int, sys.stdin.readline().split(" "))
cutPossible = [0, L] + list(set(map(int, sys.stdin.readline().split(" "))))
cutPossible.sort()


def cutResult(mid):
    cnt = 0
    cut_start = L
    prev = []
    first = 0
    # x라는 길이를 넘으면 자른다.
    for i in range(len(cutPossible) - 1, -1, -1):
        diff = cutPossible[i] - cutPossible[i - 1]
        total = cut_start - cutPossible[i]
        if diff > mid:
            return 10001, 0
        elif total > mid:
            cut_start = cutPossible[i + 1]
            prev.append(cutPossible[i + 1])
            cnt += 1
        else:
            continue

    if cnt < C:
        first = cutPossible[1]
    else:
        first = prev[-1]

    return cnt, first


left = 0
right = L
answer = 0
firstCut = 0
while left <= right:
    smallValue = (left + right) // 2
    cnt, first = cutResult(smallValue)

    if C < cnt:
        left = smallValue + 1
    else:
        answer = smallValue
        firstCut = first
        right = smallValue - 1

print(answer, firstCut)
