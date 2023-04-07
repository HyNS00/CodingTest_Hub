a = int(input())
for i in range(a):
    b = list(map(int,input().split()))
    scores = b[1:]
    student = b[0]
    avg = sum(scores) / student
    end = 0
    for score in scores:
        if score > avg:
            end += 1
            
    fot = (end / len(scores)) * 100
    print(f"{fot:.3f}%")
        