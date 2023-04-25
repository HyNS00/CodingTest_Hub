import sys
from collections import deque
input = sys.stdin.readline
R,C = map(int,input().split())
graph =[list(input().strip()) for _ in range(R)]
visited =[[0]*C for _ in range(R)]
forest = [[-1]*C for _ in range(R)]
water = [[-1]*C for _ in range(R)]

dx = [-1,1,0,0]
dy = [0,0,-1,1]
end = [] # 도착 좌표 지정
fq = deque() # 도치 이동 큐
wq = deque() # 물 이동 큐
for i in range(R):
    for j in range(C):
        if graph[i][j] == '*':
            wq.append((i,j))
            water[i][j] = 0  # 처음부터 물이 차 있는 경우, -1로 두는 것이 아닌 0으로 둔다

        elif graph[i][j] == 'D':
            # 고슴도치가 도착해야하는 장소
            end =[i,j]

        elif graph[i][j] == 'S':
            fq.append((i,j))  # 시작 좌표 큐에 삽입
            forest[i][j] = 0    # 이미 고슴도치가 위치 이 또한 0으로 두고 시작
            graph[i][j] = '.'  # 물이 들어 찰 수 있는 곳이므로 변경해줌
            
            # 돌은 고려해주지 않는다, 어차피 못 가니 굳이 넣지 말자

dx = [-1,1,0,0]
dy =[0,0,-1,1]

# 물이 먼저 차오르고 그 속도를 계산, 그 뒤에 도치가 이동
# 한 지역에 대해 물이 차는 속도가 3초 뒤인데 도치가 2초만에 도착한다면 탈출 가능. 4초만에 도착하면 탈출 x 
# 이런식으로 생각해서 문제를 푼다
def water_bfs():
    while wq:
        curX,curY = wq.popleft()
        for i in range(4):
            nx,ny = curX + dx[i] , curY + dy[i]
            # 물이 차지 않는 지역 = 비버집, 돌
            # 그 외 지역을 .으로 표시
            if 0 <= nx < R and 0 <= ny < C and water[nx][ny] == -1 and graph[nx][ny] == '.':
                water[nx][ny] = water[curX][curY] + 1
                wq.append((nx,ny))


def forest_bfs():
    while fq:
        curX,curY = fq.popleft()
        for i in range(4):
            nx,ny = curX + dx[i] , curY + dy[i]
            # 고슴도치는 물이 차지 않을 지역으로만 가능하고, 움직일 수 있는 지역으로는 . & D
            if 0 <= nx < R and 0 <= ny < C and forest[nx][ny] == -1 and (graph[nx][ny] == '.' or graph[nx][ny] == 'D'):
                # 현재 이동한 시간에 1을 더한 것보다 다음 이동할 지역이 물에 차는 시간이 크다
                # 즉 지역에 물이 차는 속도가 3인데 도치가 1초만에 도달한다면 그 지역을 지나갈 수 있기 때문이다.
                # 하지만 동시에 도착하거나 더 늦게 도착한다면 탈출 x
                # 물에 아예 잠기지 않는 지역이 있을 수 있는므로 조건 추가  , 돌이 있는 지역?
                if forest[curX][curY] +1 < water[nx][ny] or water[nx][ny] == -1:
                    forest[nx][ny] = forest[curX][curY] +1  # 지나갔다는 의미
                    fq.append((nx,ny))

water_bfs()
forest_bfs()

if forest[end[0]][end[1]] == -1:
    print("KAKTUS")
else :
    print(forest[end[0]][end[1]])
