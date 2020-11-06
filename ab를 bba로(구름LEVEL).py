# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
answer=0
user_input2 = input()
user_input = []

for i in user_input2:
    user_input.append(i)


while True :
    check = 0
    i = 0
    while True:
        if i == len(user_input) - 1:
            if user_input[-1] == 'a':
                del user_input[-1]
            break
        if user_input[i] == 'a' and user_input[i + 1] == 'b':
            check = 1
            answer += 1
            del user_input[i]
            del user_input[i]
            user_input.insert(i, 'a')
            user_input.insert(i, 'b')
            user_input.insert(i, 'b')
        i += 1

    i = -1
    while True:
        if i == 0:
            if user_input[0] == 'b':
                del user_input[0]
            break
        if user_input[i] == 'b' and user_input[i - 1] == 'a':
            check = 1
            answer += 1
            del user_input[i]
            del user_input[i]
            user_input.insert(i, 'b')
            user_input.insert(i, 'b')
            user_input.insert(i, 'a')
        i += 1
    if check == 0:
        break

#print(user_input)
print(answer)



