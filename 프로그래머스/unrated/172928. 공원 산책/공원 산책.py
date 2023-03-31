def solution(park, routes):
    answer = []
    width = len(park[0])
    height = len(park)
    dog = []
    flag = False
    for i in range(0,height):
        for j in range(0,width):
            if park[i][j] == "S":
                dog=[i,j]
                flag=True
                break
        if flag :
            break
    for i in routes:
        op,n = i.split(" ")
        n = int(n)
        dummy = True
        if op == "N":
            if dog[0]-n >= 0:
                for i in range(dog[0]-1,dog[0]-n-1,-1):
                    if park[i][dog[1]] == "X":
                        dummy=False
                        break
                if dummy :
                    dog[0]= dog[0]-n
        elif op == "S":
            if dog[0]+n <height:
                for i in range(dog[0]+1,dog[0]+n+1):
                    if park[i][dog[1]] == "X":
                        dummy=False
                        break
                if dummy :
                    dog[0] = dog[0]+n
        elif op == "W":
            if dog[1]-n >= 0:
                print(dog[1]-1,dog[1]-n)
                for i in range(dog[1]-1,dog[1]-n-1,-1):
                    print(i)                 
                    if park[dog[0]][i] == "X":
                        dummy=False
                        break
                if dummy :
                    dog[1]= dog[1]-n
        elif op == "E":
            if dog[1]+n < width:
                for i in range(dog[1]+1,dog[1]+n+1):
                    if park[dog[0]][i] == "X":
                        dummy=False
                        break
                if dummy :
                    dog[1]= dog[1]+n
    return dog