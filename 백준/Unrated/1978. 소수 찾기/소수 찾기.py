a = int(input())
b = list(map(int, input().split()))
cnt = 0
def sosu(num):
    if num == 1 :
        return False
    else :
        for i in range(2, int(num**0.5)+1):
            if num % i == 0:
                return False
            
    return True

for ex in b:
    if sosu(ex):
        cnt += 1
    
print(cnt)