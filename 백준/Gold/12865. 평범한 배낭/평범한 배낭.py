import sys
input = sys.stdin.readline

N,K = map(int,input().split())
x =[]
for _ in range(N):
    W,V = map(int,input().split())
    x.append((W,V))

graph =[[0] *(K+1) for _ in range(N+1)]

for i in range(1,N+1):
    for j in range(1,K+1):
        weight = x[i-1][0]
        value = x[i-1][1]

        if j < weight:
            graph[i][j] = graph[i-1][j]

        else :
            graph[i][j] = max(graph[i-1][j], value+graph[i-1][j-weight])

print(graph[-1][-1])