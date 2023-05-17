num = int(input())
if num == 0:
    print(1)

myFlag = 0
similarFlag = False


def getAnswer(left, right, chance):
    global similarFlag
    notFlag = False
    while 0 <= left and right >= left:
        # print(f'{myString[left]} {myString[right]}')
        if myString[left] == myString[right]:
            pass
        else:
            if chance == 0:
                notFlag = True
                break
            else:
                chance = 0
                if myString[left + 1] == myString[right] and myString[left] == myString[right - 1]:
                    newNum1 = getAnswer(left + 1, right, 0)
                    newNum2 = getAnswer(left, right - 1, 0)
                    return min(newNum1, newNum2)
                elif myString[left + 1] == myString[right]:
                    similarFlag = True
                    left += 1
                elif myString[left] == myString[right - 1]:
                    right -= 1
                    similarFlag = True
                else:
                    notFlag = True
                    break
        left += 1
        right -= 1
    if notFlag:
        return 2
    elif similarFlag:
        return 1
    else:
        if chance == 0:
            return 1
        return 0


for _ in range(num):
    myString = input()
    left = 0
    right = len(myString) - 1
    chance = 1
    if len(myString) == 3:
        if myString[0] == myString[1] and myString[1] == myString[-1] and myString[0] == myString[-1]:
            print(0)
        elif myString[0] == myString[1] or myString[1] == myString[-1] or myString[0] == myString[-1]:
            if myString[0] == myString[-1]:
                print(0)
            else:
                print(1)
        else:
            print(2)
    else:
        myFlag = 0
        similarFlag = False
        print(getAnswer(left, right, chance))
