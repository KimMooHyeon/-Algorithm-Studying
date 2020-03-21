from random import randint

# 1~45 사이에서 무작위로 6개 뽑고 오름차순으로 정렬되어 있는 리스트릴 리턴
def generate_numbers() :
    ranNum = []
    while len(ranNum)<6:
        temp = randint(1, 45)
        if temp not in ranNum:
            ranNum.append(temp)
    return sorted(ranNum)
    # generate_numbers 함수를 이용해 정렬되어있는 당첨번호 6개에다 맨 마지막에 보너스를 포함시킨 리스트 리턴. 번호는 모두 달라야하고 첫번재 껏만 오름 차순 정렬시킴
def draw_winning_numbers() :
    ranNum = generate_numbers()


    while len(ranNum) < 7:
        temp = randint(1, 45)
        if randint(1, 45) not in ranNum:
            ranNum.append(temp)
    return ranNum



# 파라미터로 list1와 리스트 list2를 받고, 두 리스트 사이에 겹치는 번호 개수를 리턴시켜준다.
def count_matching_numbers(list1, list2) :
    check_num=0
    for i in range(0,len(list1)) :
        if list1[i]==list2[i] :
            check_num+=1
    return check_num


# 파라미터로 참가자의 번호 6개가 있는 리스트 numbers와 당첨 일반 번호 여섯개와 보너스 한개가 있는 리스트 winning_numbers를 받고, 규칙에 따라 당첨 금액을 리턴
def check(numbers, winning_numbers) :
    price = count_matching_numbers(numbers,winning_numbers)
    if price == 6:
        return 1000000000
    elif price == 5 and numbers in winning_numbers:
        return 50000000
    elif price == 5 :
        return  1000000
    elif price ==4 :
        return 50000
    elif price ==3 :
        return 5000
    else:
        return 0
