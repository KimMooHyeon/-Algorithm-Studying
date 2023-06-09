num = int(input())
headFlag = True
heartFlag = True
bagFlag = True
lagFlag = True

# 행의 번호 x와 열의 번호 y
heart = []
# 왼쪽,오른쪽팔,허리, 왼쪽자리, 오른쪽 다리 길이
lag = []
bagNum = 0
leftLag = 0
rightLag = 0
for y in range(num):
    if headFlag:
        inputStr = input()
        for x in range(len(inputStr)):
            if inputStr[x] == '*':
                heart = [x + 1, y + 2]
                headFlag = False
    elif heartFlag:
        inputStr = input()
        heartFlag = False
        start = 0
        end = 0
        for x in range(len(inputStr)):
            if inputStr[x] == '*':
                start = x
                break
        for x in range(len(inputStr) - 1, -1, -1):
            if inputStr[x] == '*':
                end = x
                break
        lag.append(heart[0] - 1 - start)
        lag.append(end - (heart[0] - 1))
    elif bagFlag:
        inputStr = input()
        if inputStr[heart[0] - 1] == '*':
            bagNum += 1
        else:
            bagFlag = False
            lag.append(bagNum)
            if inputStr[heart[0] - 2] == '*':
                leftLag += 1
            if inputStr[heart[0]] == '*':
                rightLag += 1
    elif lagFlag:
        inputStr = input()
        if inputStr[heart[0] - 2] != '*' and inputStr[heart[0]] != '*':
            break
        if inputStr[heart[0] - 2] == '*':
            leftLag += 1
        if inputStr[heart[0]] == '*':
            rightLag += 1
    else:
        inputStr = input()
lag.append(leftLag)
lag.append(rightLag)
heart[0],heart[1]=heart[1],heart[0]
print(" ".join(list(map(str,heart))))
print(" ".join(list(map(str, lag))))
