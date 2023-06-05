# n개 웅덩이, l 길이 널빤지
import math

(n, l) = map(int, input().rstrip().split(" "))
hole = []
answer = 0
for i in range(n):
    (start, end) = map(int, input().rstrip().split(" "))
    hole.append([start, end])
hole.sort(key=lambda x: x[1])
saveNum = 0
if len(hole) == 1:
    print(math.ceil((hole[0][1] - hole[0][0]) / l))
else:
    for i in range(len(hole)):
        #print()
        #print(f'시작 안전길이 {saveNum} , {hole[i]} , 추가개수 {answer}')
        if saveNum < hole[i][1]:
            if saveNum < hole[i][0]:
                saveCount = math.ceil((hole[i][1] - hole[i][0]) / l)
                answer += saveCount
                saveNum = hole[i][0] + saveCount * l
            else:
                saveCount = math.ceil((hole[i][1] - saveNum) / l)
                answer += saveCount
                saveNum += saveCount * l
        #print(f'실행완료 안전길이 {saveNum} , {hole[i]} , 추가개수 {answer}')
print(answer)

# .MMMMM..MMMM.MMMM.... // 웅덩이
