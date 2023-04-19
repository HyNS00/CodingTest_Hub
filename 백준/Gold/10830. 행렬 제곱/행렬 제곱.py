import sys

input = sys.stdin.readline

N,B = map(int,input().split())
matrix = []
for _ in range(N):
    matrix.append(list(map(int,input().split())))

# 행렬
def mul_matrix (mat1,mat2):
    res =[[0] * N for _ in range(N)]
    for i in range(N):
        for j in range(N):
            for k in range(N):
                res[i][j] += mat1[i][k] * mat2[k][j] % 1000

    return res


def power(a,b):
    if b== 1:
        return a
    
    else :
        tmp = power(a, b // 2)
        if b % 2 == 0:
            return mul_matrix(tmp,tmp)
        
        else :
            return mul_matrix(mul_matrix(tmp,tmp),a)
        
result = power(matrix,B)

for row in result:
    for col in row:
        print(col % 1000, end = ' ')

    print()