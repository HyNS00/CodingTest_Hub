import sys
input = sys.stdin.readline
small = []
n,m = map(int,input().split())
for _ in range(m):
    small.append(int(input()))

INF = float('inf')
# 막히지 않고 속도가 계속 속도가 증가하면 가능
max_speed = int((2*n)**(1/2)) +1  # 등차수열

# dp[i][j] =i 속도로 j번 돌로 온 최소 횟수
dp =[[INF]* (max_speed+1) for _ in range(n+1)] # 인덱스 값이라서 +1

# 일반적인 상황이라면 2번으로 이동해야하나
# 2번 돌로 이동할 수 없는 상황이라면
if 2 not in small:
    dp[2][1] = 1 #기저값
    for num in range(3,n+1): # 3번 돌부터
        if num not in small: # 올라갈 수 있는 돌이면
            for speed in range(1,max_speed):
                # 1. num-speed = 전위치
                # 2. 각각 현재 속도의 -1 , 0, 1만큼의 이동 횟수를 가져온다.
                # 3. 가장 작은 값에  +1  _ 무조건 한칸이상 이동해야한다.

                dp[num][speed] = min(dp[num-speed][speed-1],dp[num-speed][speed],dp[num-speed][speed+1])+1

ans = min(dp[n])
if ans == INF: # 도달하지 못함
    print(-1)
else :
    print(ans)