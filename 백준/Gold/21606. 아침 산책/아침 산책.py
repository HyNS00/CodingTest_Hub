import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**9)

N = int(input())
location = [0]+ list(map(int,input().strip()))

graph =[[] for _ in range(N+1)]
indoor = 0
for _ in range(N-1):
    a,b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)
    if location[a] == 1 and location[b] == 1:
        indoor += 2

visited =[0] * (N+1)
sum = 0

def dfs(v,cnt):
    visited[v] = 1
    for i in graph[v]:
        if location[i] == 1 :
            cnt +=1
        
        elif visited[i] == 0 and location[i] == 0:
            cnt = dfs(i,cnt)

    return cnt


for i in range(1,N+1):
    if visited[i] == 0 and location[i] == 0:
        x = dfs(i,0)
        sum += x*(x-1)

print(sum+indoor)