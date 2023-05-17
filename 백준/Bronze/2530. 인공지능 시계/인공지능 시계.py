a, b, c= map(int, input().split(" "))
d = int(input())

plusMin = (c+d)/60
sec = (c+d)%60

plusHour = (plusMin+b)/60
min = (plusMin+b)%60

hour = (plusHour+a)%24

print(f'{int(hour)} {int(min)} {int(sec)}')