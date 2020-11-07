from collections import Counter
import operator

def solution(genres, plays):
    answer = []
    plays_sum={}
    plays_list=[]
    genres_list=Counter(genres)
    #print(genres_list,len(genres_list))
    for i in genres_list :
        plays_sum[i]=0
    #print(plays_sum)
    for i in range(len(genres)):
        plays_sum[genres[i]]+=plays[i]
        plays_list.append([genres[i],plays[i],i])
    s_plays_sum = list(sorted(plays_sum.items(), key=operator.itemgetter(1)))
    #print(s_plays_sum)

    plays_list.sort(key=lambda x :(x[0],-x[1],x[2]))
   # print(plays_list)

    while len(answer) < len(s_plays_sum):
        for i in range(len(s_plays_sum)-1,-1,-1):
     #       print(s_plays_sum[i])
            genres_name=s_plays_sum[i][0]
      #      print(genres_name)

            for j in range(len(plays_list)):
  #              print(len(plays_list),j)
 #               print(plays_list[j][0],genres_name)
                if plays_list[j][0] == genres_name :
                    answer.append(plays_list[j][2])
                    if j+1<len(plays_list):
                        if plays_list[j+1][0] == genres_name :
                            answer.append(plays_list[j+1][2])
                        break

    return answer

#print(solution(["classic"],[500]))