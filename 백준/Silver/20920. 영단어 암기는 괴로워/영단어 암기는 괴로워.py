import sys
input = sys.stdin.readline

n,m = map(int,input().split())
dic = {}
cnt = 0
result = []
for _ in range(n):
    a = input().strip()
    if len(a) >= m:
        if a in dic:
            dic[a] += 1
        else :
            dic[a] = 1

result  = sorted(dic.items(),key = lambda x: (-x[1], -len(x[0]), x[0]))
# value의 내림차순으로 정리, len(x[0])은 내림차순으로 정리, x[0]의 오름차순으로 정리
for i in range(len(result)):
    print(result[i][0])