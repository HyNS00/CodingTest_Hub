import sys
import heapq
N = int(input())
graph =[]
for _ in range(N):
    a = list(map(int,input().strip()))
    graph.append(a)
visited = [[0]*N for _ in range(N)]

dx =[-1,0,1,0]
dy =[0,-1,0,1]

# 다익스트라
def dijkstra():
    q =[]
    heapq.heappush(q,[0,0,0])
    visited[0][0] = 1
    while q:
        a,x,y = heapq.heappop(q)
        if x == N-1 and y == N -1 :
            print(a)
            return
        
        for i in range(4):
            nx = x+ dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < N and visited[nx][ny] == 0:
                visited[nx][ny] = 1
                if graph[nx][ny] == 0 :
                    heapq.heappush(q,[a+1,nx,ny])
                else :
                    heapq.heappush(q,[a,nx,ny])


dijkstra()