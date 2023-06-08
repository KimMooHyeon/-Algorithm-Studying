def dfs(n, m, selectList, numList, checkHash, printHash):
    if len(selectList) == m:
        temp = ""
        for i in sorted(selectList):
            temp += str(i) + " "

        if temp not in printHash:
            print(temp)
            printHash[temp] = False
        return
    else:
        for i in range(n):
            if i not in checkHash or checkHash[i] == True:
                selectList.append(numList[i])
                checkHash[i] = False
                dfs(n, m, selectList, numList, checkHash, printHash)
                selectList.pop()
                checkHash[i] = True


printHash = {}
checkHash = {}
(n, m) = map(int, input().rstrip().split(" "))
numList = list(map(int, input().rstrip().split(" ")))
numList.sort()
dfs(n, m, [], numList, checkHash, printHash)
