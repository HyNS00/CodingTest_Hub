import sys
from collections import deque
input = sys.stdin.readline
# 악지 않는 개수 cnt

def bfs():
    # [1] q생성, v[]생성
    q= deque()
    v =[[[0]* M for _ in range(N)] for _ in range(H)]

    # 2. q에 초기 데이터들을 삽입, 안익은 토마토 카운트
    cnt = 0
    for h in range(H):
        for i in range(N):
            for j in range(M):
                if arr[h][i][j] == 1 : # 익은 토마토
                    q.append((h,i,j))
                    v[h][i][j] = 1

                elif  arr[h][i][j] == 0 : # 안익은 토마토
                    cnt += 1

    while q:
        ch,ci,cj = q.popleft()

        # 6방향, 범위내, 미방문, arr[] == 0
        for dh,di,dj in ((0,-1,0),(0,1,0),(0,0,-1),(0,0,1),(-1,0,0),(1,0,0)) :
            nh,ni,nj = ch+dh, ci+di,cj+dj
            if 0 <= nh < H and 0 <= ni < N and 0 <= nj < M and v[nh][ni][nj] ==0 and arr[nh][ni][nj] == 0:
                q.append((nh,ni,nj))
                v[nh][ni][nj] = v[ch][ci][cj] +1
                cnt -= 1     # 안익은 토마토가 1개 익음


    if cnt == 0 :
        return   v[ch][ci][cj] - 1  
    
    else :
        return -1
# 확인을 H - N - M 순서로 간다.
# q생성, v생성
# 초기데이터들 삽입 v() <-1
# for H N M 전체 삽입
# 0이면 cnt += 1
'''
while q:
        ch,ci,cj = q.pop(0)
        6방향 범위내, 미방문 arr == 0
        q에 삽입, v[] <- v[c] +1
        cnt -= 1
        if cnt ==0: return v[ch][ci][cj] -1
        처음에 1을 넣었으니까 1을 뺌
        else 
        return -1
'''
M,N,H = map(int,input().split())
arr =[[list(map(int,input().split())) for  _ in range(N)]for _ in range(H)]
ans =bfs()
print(ans)
