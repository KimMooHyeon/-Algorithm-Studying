def getDistance(lux,luy,rdx,rdy):
    return abs(rdx - lux) + abs(rdy - luy)

def solution(wallpaper):
    answer = []
    minY = len(wallpaper)
    minX = len(wallpaper[0])
    maxX = maxY = 0

    for y in range(0,len(wallpaper)) :
        for x in range(0,len(wallpaper[0])):
            if wallpaper[y][x] == "#":
                if y > maxY :
                    maxY=y
                if y < minY :
                    minY=y
                if x > maxX :
                    maxX=x
                if x < minX :
                    minX=x
    

    return [minY,minX,maxY+1,maxX+1]
