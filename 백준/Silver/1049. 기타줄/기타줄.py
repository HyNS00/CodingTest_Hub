import sys
input = sys.stdin.readline
n,m = map(int,input().split())
single = package = sys.maxsize

for _ in range(m):
    a,b = map(int,input().split())
    package = min(a,package)
    single = min(b,single)

# 최소 패키지와 최소 낱개 갯수로 만 구매
result = sys.maxsize
ans = (n //6) * package + (n % 6) * single 
result = min(result,n*single, ans, package*(n//6 +1))
print(result)