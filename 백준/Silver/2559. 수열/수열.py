# https://www.acmicpc.net/problem/2559
import sys
input = sys.stdin.readline

n,k = map(int,input().split())

# 연속적인 온도의 합 
# 그리드
# 어떻게 접근할까 그리드를...
# 무식하게 진행
lst = list(map(int,input().split()))
# print(lst)



current = sum(lst[:k])
result = current
for i in range(n-k):
    current = current - lst[i] + lst[i+k]
    result = max(result, current)

print(result)
# 윈도우 슬라이싱
