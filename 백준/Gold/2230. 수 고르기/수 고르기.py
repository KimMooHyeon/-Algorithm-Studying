import sys
import heapq

# 두 원소의 차이중 가장 큰 값
# 두 원소의 차잊우 가장 작은 값
# k개를 제거
ans = 2000000009
n, m = map(int, sys.stdin.readline().split(" "))
mList = []
for i in range(n):
    mList.append(int(sys.stdin.readline()))
mList.sort()

end = 0

for start in range(len(mList)):
    while end < len(mList):
        dif = mList[end] - mList[start]
        if dif >= m:
            ans = min(dif, ans)
            break  # while문 빠져나가고 start 하나 올려주기
        else:
            end += 1

print(ans)
