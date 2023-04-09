num = int(input())
cnt = 0
for i in range(1, num+1): 
    if i < 100 :
        cnt += 1
    elif i < 1000 :
        if (i // 100) -(i % 100 // 10) == (i % 100 // 10) - (i % 10) :
            cnt += 1
        
print(cnt)