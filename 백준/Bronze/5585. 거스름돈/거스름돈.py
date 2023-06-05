moneyList = [500, 100, 50, 10, 5, 1]
n = 1000 - int(input().rstrip())
moneyIndex = 0
answer = 0
while n > 0:
    if n < moneyList[moneyIndex]:
        moneyIndex += 1
    else:
        num = n // moneyList[moneyIndex]
        answer += num
        n %= moneyList[moneyIndex]
print(answer)