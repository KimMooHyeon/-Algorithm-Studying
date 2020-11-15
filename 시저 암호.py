def solution(s, n):
    answer = ''
    ans_list=[]
    for v in s :
        if 97<=ord(v)<=122:
            if ord(v)+n>122:
                answer+=chr(ord(v)+n-26)
            else:
                answer+=chr(ord(v)+n)
        elif 65<=ord(v)<=90:
            if ord(v)+n>90:
                answer+=chr(ord(v)+n-26)
            else:
                answer+=chr(ord(v)+n)
        else:
            answer+=v
    return answer