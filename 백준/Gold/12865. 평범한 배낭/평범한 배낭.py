import sys
input = sys.stdin.readline

N,K = map(int,input().split())
x =[]
for _ in range(N):
    W,V = map(int,input().split())
    x.append((W,V))

memo = [[-1] *(K+1) for _ in range(N+1)]

def knapsack(n, k):
    if n == 0 or k == 0:
        return 0

    if memo[n][k] != -1:
        return memo[n][k]

    weight = x[n-1][0]
    value = x[n-1][1]

    if k < weight:
        memo[n][k] = knapsack(n-1, k)
    else:
        memo[n][k] = max(knapsack(n-1, k), value+knapsack(n-1, k-weight))

    return memo[n][k]

print(knapsack(N, K))