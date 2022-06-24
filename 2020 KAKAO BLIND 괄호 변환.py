# 두 문자열 u,v 분리 함수
def distinct(p):
    tmp=""
    cnt=0
    u=""
    v=""
    return_arr=[]
    for i,value in enumerate(p):
        if value=='(':
            u+=value
            cnt+=1
        elif value == ')':
            u+=value
            cnt-=1
        if cnt==0:
            v=p[i+1:]
            return u,v  
# 올바른 괄호 문자열인지 확인 함수
def check_arr(arr):
    cnt=0
    for i,v in enumerate(arr):
        if v == '(':
            cnt+=1
        elif v == ')':
            cnt-=1
        if cnt<0:
            return False 
        if i == (len(arr)-1):
            if cnt == 0:
                return True
            else:
                return False

def recur_fun(w):
    if w == '':
        return ''
        
    u,v=distinct(w)
    if check_arr(u) :
        return u+recur_fun(v)
    else:
        tmp='('+recur_fun(v)+')'
        tmp_u=[]
        for index in range(1,len(u)-1):
            if u[index] =='(':
                tmp_u.append(')')
            else:
                tmp_u.append('(')
        tmp+=''.join(tmp_u)
    return tmp
                

def solution(p):
   # u,v=distinct(p)
    answer = ''
    # 균형 잡힌 문자열은 '('의 개수와 ')'의 개수가 같다
    
    # 1 입력이 빈 문자열인 경우 빈 문자열 반환
    # 2. 문자열을 균형잡힌 u,v로 분리
    # 단 u는 균형잡힌 문자열로 더 이상 분리 할 수 없어야함 
    answer=recur_fun(p)

    
    return answer