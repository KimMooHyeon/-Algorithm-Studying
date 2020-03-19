from random import randint
landom_num=0
temp=0
problem=[]
while landom_num<=2:
    temp=randint(0,9)
    if not temp in problem:
        problem.append(temp)
        landom_num=landom_num+1


print(problem)
print("0과 9 사이의 서로 다른 세 숫자를 랜덤한 순서로 뽑았습니다.")
challenge=0
while True:
    i=1
    s_num=0
    b_num=0
    judge=0
    judge_list=[]
    challenge = challenge + 1
    print("세 수를 하나씩 차례대로 입력하세요.")
    while i<=3:
        judge = int(input("{}번째 수를 입력하세요: ".format(i)))
        if judge<=-1 or 10<=judge :
            print("범위를 벗어나는 수입니다. 다시 입력해주세요.")
            continue
        elif judge in judge_list:
            print("중복되는 수 입니다. 다시 입력해주세요.")
            continue
        else:
            judge_list.append(judge)
            i=i+1
    start =0
    while start<=2:
        if problem[start]==judge_list[start]:
            s_num=s_num+1
        if judge_list[start] in problem:
            b_num=b_num+1
        start=start+1
    start=0

    if s_num==3 and b_num==3 :
        # 만약 같으면
        print()
        print()
        print("축하합니다. {}번만에 세 숫자의 값과 위치를 모두 맞추셨습니다.".format(challenge))
        break

    #코드
    print("{}S {}B".format(s_num,b_num-s_num))



