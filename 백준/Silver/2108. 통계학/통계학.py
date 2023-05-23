# https://www.acmicpc.net/problem/2108
# 굳이 함수를 쓰지말고 몫을 구하는 것에 치중해보자
# 빠른 속도를 위해서는 list보다는 딕셔너리 활용에 치중에 해보자.
# dic[key] = values 출력
import sys
input = sys.stdin.readline
sum =0
n = int(input())
lst = []
for _ in range(n):
    a = int(input())
    lst.append(a)
    sum += a

lst.sort()

mean = sum / n
print(round(mean)) # 문제의 조건을 만족하기 위한 round

median = lst[n//2]  # 처음에는 다르게 했지만, 중앙값을 표현하기 위해 좀 더 깔끔하다.
print(median)

# 아이디어가 매우 좋았다.

dic ={}
for num in lst:
    if num in dic:
        dic[num] += 1
    
    else :
        dic[num] = 1
# 최빈값을 저장하는 값을 넣는다.
max_count = max(dic.values())
mx_dic = []

for i in dic:  # 이미 dic을 만들 때 sort한 list에서 차례대로 받았기 때문에 값들의 순서는 동일하다.
    if max_count == dic[i]:
        mx_dic.append(i)
if len(mx_dic) > 1: # 최빈값이 여러 개라면 
    print(mx_dic[1]) # 최빈값들 중 2번 째
else :
    print(mx_dic[0])

print(lst[-1] - lst[0])