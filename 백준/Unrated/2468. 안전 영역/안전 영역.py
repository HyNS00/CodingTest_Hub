
import sys
input = sys.stdin.readline
sys.setrecursionlimit(100000)
N = int(input())
land = []
land = [list(map(int,input().split())) for i in range(N)]
dx = [1,0,-1,0]
dy = [0,1,0,-1]
result = 0
def dfs(x,y,h):
    if h >= land[x][y]:
        check[x][y] = True  # 비온 곳 확인
        return False
    check[x][y] = True #안전 구역 확인
    for i in range(4):
        nx,ny = x+dx[i] , y+dy[i]
        if(0<= nx < N and
           0<= ny < N and
           not check[nx][ny]):
            dfs(nx,ny,h)
    return True
for k in range(max(map(max, land))): # k 가 높이
    check = [[False]*N for i in range(N)] # 확인한 장소인지 체크
    sum = 0
    for i in range(N):
        for j in range(N):
           if not check[i][j] and dfs(i,j,k):
               sum += 1
    if result < sum :
        result = sum
print(result)