a,b = input().split()

re_a = int(a[::-1])
re_b = int(b[::-1])

print(max(re_a,re_b))