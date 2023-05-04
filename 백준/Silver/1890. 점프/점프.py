import sys
input =sys.stdin.readline

n = int(input())
graph = []
for _ in range(n):
    graph.append(list(map(int,input().split())))

# print(graph)
dp =[[0]*n for _ in range(n)]
dp[0][0] = 1
for i in range(n):
    for j in range(n):
        if i == n-1 and j == n -1 :
            print(dp[i][j])
            break
        go = graph[i][j]
        
        if j + go < n:
            dp[i][j+go] += dp[i][j]

        if i + go < n:
            dp[i+go][j] += dp[i][j]

        
