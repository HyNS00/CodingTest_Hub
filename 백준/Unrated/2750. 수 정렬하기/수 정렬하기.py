a = int(input())
test = []
for _ in range(a):
    b = int(input())
    test.append(b)
    
test.sort()
for t in test:
    print(t)