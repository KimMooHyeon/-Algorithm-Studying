price = 50000000
year = 1988
while year < 2016:
    price = price + (price * 12) / 100
    year = year + 1

if price > 1100000000:
    print("{}원 차이로 동일 아저씨의 말씀이 맞습니다.".format(int(price) - 1100000000))
else:
    print("{}원 차이로 미란 아주머니의 말씀이 맞습니다.".format(1100000000 - int(price)))