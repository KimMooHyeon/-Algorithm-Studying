king_space , stone_space , N = input().split()

int_king_space=[]
int_stone_space=[]

int_king_space.append( (ord(king_space[0])-65))
int_king_space.append (7-(int(king_space[1])-1))

int_stone_space.append((ord(stone_space[0])-65))
int_stone_space.append(7-(int(stone_space[1])-1))

king_direction=[]
def chage(x,y):
    return chr(x+65)+ str(7-y+1)

for i in range(int(N)) :
    dir = input()
    if dir == 'R':
        king_direction.append([1,0])
    elif dir == 'L' :
        king_direction.append([-1, 0])
    elif dir == 'B' :
        king_direction.append([0, 1])
    elif dir == 'T' :
        king_direction.append([0, -1])
    elif dir == 'RT' :
        king_direction.append([1, -1])
    elif dir == 'LT' :
        king_direction.append([-1, -1])
    elif dir == 'RB' :
        king_direction.append([1, 1])
    elif dir == 'LB' :
        king_direction.append([-1, 1])

last_space=int_king_space

for i in range (int(N)):
    x = int_king_space[0]
    y = int_king_space[1]

    dx=int_king_space[0] + king_direction[i][0]
    dy=int_king_space[1] + king_direction[i][1]
    if dx <0 or dy <0 or dx>7 or dy>7 :
        dx-=king_direction[i][0]
        dy-= king_direction[i][1]
        continue
    int_king_space[0]=dx
    int_king_space[1]=dy
    if int_king_space == int_stone_space :
        sdx = int_stone_space[0] + king_direction[i][0]
        sdy = int_stone_space[1] + king_direction[i][1]
        if sdx < 0 or sdy < 0 or sdx > 7 or sdy > 7:
            sdx-=king_direction[i][0]
            sdy-=king_direction[i][1]
            int_king_space =[x,y]

            continue
        int_stone_space[0] = sdx
        int_stone_space[1] = sdy

print(chage(int_king_space[0],int_king_space[1]))
print(chage(int_stone_space[0],int_stone_space[1]))



