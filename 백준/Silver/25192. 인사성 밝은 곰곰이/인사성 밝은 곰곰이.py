import sys
input = sys.stdin.readline

n = int(input())

s = set()
ans = 0

for i in range(n):
    user = input().strip()
    if user =='ENTER':
        ans += len(s)
        s.clear()

    else :
        s.add(user)

ans += len(s)
print(ans)