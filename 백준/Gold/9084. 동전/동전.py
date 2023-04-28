import sys
input = sys.stdin.readline


# 테스트 케이스
t = int(input())
for _ in range(t):
    n = int(input())
    coins = list(map(int,input().split()))

    m = int(input()) # 목표치
    d = [0] * (m+1)

    d[0] = 1   # 아무것도 안낼 경우
    for coin in coins:
        for i in range(1,m+1):
            if i >= coin :
                d[i] += d[i-coin]

    print(d[m])