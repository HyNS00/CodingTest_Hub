test = []
test_sum = 0
for j in range(9):
    test.append(int(input()))
    test_sum += test[j]

for i in range(8):
    
    for j in range(i+1,9):
        test_ar = test_sum
        k = test[i] + test[j] 
        if  test_ar - k == 100:
            test[i],test[j] =0,0
            break

    if  test_ar - k == 100:
        break
test.sort()
for k in test:
    if k != 0 :
        print(k)