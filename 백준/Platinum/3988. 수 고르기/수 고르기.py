import sys
from collections import deque

# 두 원소의 차이중 가장 큰 값
# 두 원소의 차잊우 가장 작은 값
# k개를 제거

n, k = map(int, sys.stdin.readline().split(" "))
nList = list(map(int, sys.stdin.readline().split(" ")))
nList.sort()

dequeList = deque()
# k를 제외한 범위
dataGap = n - k - 1
result = nList[-1] - nList[0]
for i in range(n - 1):
    # 인덱스와 데이터간의 gap 차이
    gap = [i, nList[i + 1] - nList[i]]
    if len(dequeList) != 0 and dequeList[0][0] <= i - dataGap:
        dequeList.popleft()
    while len(dequeList) != 0 and dequeList[-1][1] > gap[1]:
        dequeList.pop()
    dequeList.append(gap)
    if i + 1 >= dataGap:
        m = nList[i + 1] - nList[i + 1 - dataGap]
        result = min(result, dequeList[0][1] + m)
print(result)
