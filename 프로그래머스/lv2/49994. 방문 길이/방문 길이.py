def solution(dirs):
    answer =0
    map_arr=[[False]*11 for _ in range(11)]
    map_arr[5][5]=True
    dirsList =list(dirs)
    nowY = 5
    nowX = 5
    hash={}
    for i in dirsList:
        if i =="U":
            if nowY != 0:
                nowY-=1
                if ("y",nowY,nowY+1,nowX) not in hash:
                    hash[("y",nowY,nowY+1,nowX)] =True
                    hash[("y",nowY+1,nowY,nowX)] =True
                    answer+=1
        elif i== "D":
            if nowY != 10:
                nowY+=1
                if ("y",nowY,nowY-1,nowX) not in hash:
                    hash[("y",nowY,nowY-1,nowX)] =True
                    hash[("y",nowY-1,nowY,nowX)] =True
                    answer+=1
        elif i== "L":
            if nowX != 0:
                nowX-=1
                if ("x",nowY,nowX,nowX+1) not in hash:
                    hash[("x",nowY,nowX,nowX+1)] =True
                    hash[("x",nowY,nowX+1,nowX)] =True
                    answer+=1
        elif i== "R":
            if nowX != 10:
                nowX+=1
                if ("x",nowY,nowX,nowX-1)  not in hash:
                    hash[("x",nowY,nowX,nowX-1)] =True
                    hash[("x",nowY,nowX-1,nowX)] =True
                    answer+=1
        #print(f'{i} {answer} ({nowY},{nowX})')
    return answer