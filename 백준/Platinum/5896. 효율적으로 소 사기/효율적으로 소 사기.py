import sys
import heapq

# n개의 소를 최대한 많이 사기
# m원 과 k개의 소 쿠폰
# 소 쿠폰은 소 한마리당 한번 사용
# i번째의 소는 Pi원이고, 쿠폰을 쓰면 Ci원
# 최대로 살 수 있는 소 마릿수 구하기
n, k, m = map(int, sys.stdin.readline().split(" "))
nList = []
answer = 0
for i in range(n):
    nList.append(list(map(int, sys.stdin.readline().split(" "))))
nList.sort(key=lambda x: x[1])
couponBuyList = []
notCouponBuyList = []

for cow in nList:

    if k > 0:
        if cow[1] > m:
            break
        k -= 1
        m -= cow[1]
        answer += 1
        heapq.heappush(couponBuyList, (cow[0], cow))
    else:
        # 쿠폰 안사용해도됨
        nomal = m - cow[0]
        coupon = m + couponBuyList[0][1][1] - (cow[1] + couponBuyList[0][1][0])
        temp = -1
        if len(notCouponBuyList) > 0:
            if notCouponBuyList[0][1][0] > cow[0]:
                temp = m + notCouponBuyList[0][1][0] - cow[0]

                # heapq.heappush(notCouponBuyList, (-cow[0], cow))

        # 쿠폰을 쓴거중에 노말 가격이나 현재 노말로 살 수있으면 answer+=1
        if coupon < 0 and nomal < 0:
            if temp < 0 :
                continue
            else:
                m = temp
                heapq.heappop(notCouponBuyList)
                heapq.heappush(notCouponBuyList, (-cow[0], cow))
                nomal = m - cow[0]
                coupon = m + couponBuyList[0][1][1] - (cow[1] + couponBuyList[0][1][0])
                if coupon < 0 and nomal < 0:
                    continue
                else:
                    answer += 1
                if nomal >= coupon:
                    m = nomal
                    heapq.heappush(notCouponBuyList, (-cow[0], cow))
                else:
                    m = coupon
                    heapq.heappop(couponBuyList)
                    heapq.heappush(couponBuyList, (cow[0], cow))
        else:
            answer += 1
        if nomal >= coupon:
            m = nomal
            heapq.heappush(notCouponBuyList, (-cow[0], cow))
        else:
            m = coupon
            heapq.heappop(couponBuyList)
            heapq.heappush(couponBuyList, (cow[0], cow))
print(answer)
