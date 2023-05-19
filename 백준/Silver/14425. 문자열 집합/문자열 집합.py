import sys
input = sys.stdin.readline

n,m = map(int,input().split())
dic ={}
for _ in range(n):
    dic[input().strip()] = 1
cnt = 0
for _ in range(m):
    if input().strip() in dic:
        cnt += 1

print(cnt)