a = int(input())
b = int(input())
c = int(input())

result = a * b * c
for i in range(10):
    cnt = 0
    for test in list(str(result)):
        if str(i) == test:
            cnt += 1
    print(cnt) 