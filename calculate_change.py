def calculate_change(payment, cost):
    
    change  = payment-cost
    a=50000
    b=10000
    c=5000
    d=1000
    print("{0}원 지폐: {1}장".format(a, change // a))
    print("{0}원 지폐: {1}장".format(b, change%a // b))
    print("{0}원 지폐: {1}장".format(c, change%b // c))
    print("{0}원 지폐: {1}장".format(d, change%c // d))


# 테스트
calculate_change(100000, 33000)
print()
calculate_change(500000, 378000)