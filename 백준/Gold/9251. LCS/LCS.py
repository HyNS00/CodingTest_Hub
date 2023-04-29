import sys
input = sys.stdin.readline

# lcs 어떻게 진행할 것인가?
# 이중 for문


# x를 받은 다음에  리스트로 변환

x = list(input().strip()) # .strip() 으로 공백 제거
y = list(input().strip()) 
# 고민해봐야할 점 .: list를 안써도 될까??

graph =[[0]*(len(y)+1) for _ in range(len(x)+1)]  # 길이를 넣을 때 , len(x)+1로 하는 이유는 0인덱스를 하는 것
# 숫자로 0
# 그게 하나가 
for i in range(1,len(x)+1):
    for j in range(1, len(y)+1):
        if x[i-1] == y[j-1] : # 마지막 번호까지 돌게 하기 위해
            graph[i][j] = graph[i-1][j-1] +1

        else :
            graph[i][j] = max(graph[i][j-1], graph[i-1][j])


print(graph[-1][-1])
