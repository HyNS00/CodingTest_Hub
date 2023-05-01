import sys
input = sys.stdin.readline

n = int(input()) # 행렬의 개수
matrix = []  # n개의 행렬을 입력받아 matrix리스트에 저장한다.
# 행렬 받기
for _ in range(n):
    r,c = map(int,input().split())
    matrix.append((r,c))
# 동적 dp테이블 초기화
dp = [[0] *n for _ in range(n)]  #i,j구간의 최솟값을 저장하는 2차원 리스트

for i in range(1,n): # i는 구간의 길이를 의미
    for j in range(n-i): # j는 구간의 시작 인덱스
        '''
        행렬의 크기는 n,연산을 수행하려면 최소 2개의 행렬이 필요하므로, j의 범위는 0부터 n-2까지, 인덱스j부터 n-1까지를 선택
        심지어 j는 대각선에서 위쪽만 계산하면 되므로 범위가 0 ~ n-i
        '''
        x,y = j, i+j # x,y는 현재구간을 의미하는 변수
        dp[x][y] = 2**32 # 최대값으로 초기화
        for k in range(x,y):
            dp[x][y] = min(dp[x][y], dp[x][k] + dp[k+1][y] +matrix[x][0]*matrix[k][1]*matrix[y][1])
            '''
            dp[x][k] x부터 k까지의 행렬을 곱한 최솟값
            dp[k+1][y] = k+1부터 y까지의 행렬을 곱한 최솟값
            matrix[x][0]*matrix[k][1]*matrix[y][1] : x부터 y까지의 행렬을 곱할 때의 곱셈 연산 횟수
            dp[x][y]와 비교하여 더 작은 값을 dp[x][y]에 저장
            '''
print(dp[0][n-1])
