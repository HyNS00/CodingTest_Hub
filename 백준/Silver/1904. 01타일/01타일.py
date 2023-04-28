import sys
input = sys.stdin.readline

N = int(input())

def binary(n) :
    dp = [0] * (n+1)
    dp[1] = 1
    if n == 1 :
        return dp[1]
    
    dp[2] = 2
    for i in range(3, n+1) :
        dp[i] = (dp[i-1] + dp[i-2]) % 15746
    return dp[n]

print(binary(N))