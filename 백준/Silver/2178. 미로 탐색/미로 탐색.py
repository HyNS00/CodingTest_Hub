import sys
input = sys.stdin.readline
from collections import deque
N,M = map(int,input().split())
graph =[]
for i in range(N):
    graph.append(list(map(int,input().strip())))

dx = [-1,1,0,0] # 좌우
dy = [0,0,-1,1] # 상하

def bfs(x,y):
    queue = deque()
    queue.append((x,y))
    while queue:
        x,y = queue.popleft()
        for i in range(4): # 현재 위치에서 네 방향으로 위치 확인
            nx = x +dx[i]
            ny = y+ dy[i]

            # 미로 공간을 벗어날 경우
            if nx >= N or ny >= M or nx < 0 or ny <0 :
                continue # 다른 숫자로 진행

            if graph[nx][ny] == 0:
                continue
            if graph[nx][ny] == 1:
                graph[nx][ny] = graph[x][y] + 1 # 다음 위치로 이동할 때의 거리
                queue.append((nx,ny))
    return graph[N-1][M-1]

print(bfs(0,0))