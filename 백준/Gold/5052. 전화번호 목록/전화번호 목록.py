
t = int(input())
for _ in range(t):
    n = int(input())
    phoneList = []
    for _ in range(n):
        phone = input()
        phoneList.append(phone)
    endFlag = False
    phoneList.sort(key=lambda x: len(x))
    smallSize = len(phoneList[0])
    maxSize = len(phoneList[-1])
    hash = {}
    smallSizeHash = {}
    for num in phoneList:
        hashNum = num[0:smallSize]
        curNumSize = len(num)
        smallSizeHash[curNumSize] = True
        if hashNum in hash:
            endFlag = True
            break
        hash[num] = True

        for j in range(smallSize, maxSize):
            if curNumSize <= j or endFlag:
                break
            else:
                hashNum += num[j]
                if j in smallSizeHash:
                    if hashNum != num:
                        if hashNum in hash:
                            endFlag = True
                            break

    if endFlag:
        print("NO")
    else:
        print("YES")
