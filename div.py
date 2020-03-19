i = 1 
num = 0 

while i <= 120 :
    if 120%i == 0:
        num = num+1
        print(i)
    i=i+1
print("120의 약수는 총 {}개입니다.".format(num))    
