def findParent(parent,x):
    if parent[x] != x :
        parent[x] = findParent(parent,parent[x])
    return parent[x]
        
def unionParent(parent,a,b):
    a = findParent(parent,a)
    b = findParent(parent,b)
    if a < b:
        parent[b] = a
    else:
        parent[a] =b
        
def solution(n, wires):
    answer = 1000
    parent = [0] * (n+1)
    for i in range(n+1):
        parent[i]=i
    
    for i in range(0,len(wires)):
        curParent = parent.copy()
        edge = []
        for j in range(0,len(wires)):
            if(i != j):
                edge.append(wires[j])
        for k in edge:
            if findParent(curParent,k[0]) != findParent(curParent,k[1]):
                unionParent(curParent,k[0],k[1])
     
        for i in range(0, n+1):
            findParent(curParent,i)
        start = curParent[1]
        startSame =1
        startDifferent = 0
        for i in range(2,n+1):
            if start == curParent[i]:
                startSame+=1
            else:
                startDifferent+=1
        if startSame > startDifferent:
            answer = min(answer,startSame-startDifferent)
        else:
            answer = min(answer,startDifferent-startSame)

    return answer