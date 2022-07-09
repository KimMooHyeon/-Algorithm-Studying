max_num=0
people_num=0
for i in range(10):
    out_num,in_num= map(int,input().split())
    people_num-=out_num
    people_num+=in_num
    max_num=max(max_num,people_num)
print(max_num)