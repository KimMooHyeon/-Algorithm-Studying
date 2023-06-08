def dfs(n, m, selectList):
    if len(selectList) == m:
        print(' '.join(selectList))
        return
    else:
        for i in range(1, n + 1):
            selectList.append(str(i))
            dfs(n, m, selectList)
            selectList.pop()


(n, m) = map(int, input().rstrip().split(" "))
dfs(n, m, [])
