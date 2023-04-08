def sosu(num):
    if num == 1 :
        return False
    else :
        for i in range(2, int(num**0.5)+1):
            if num % i == 0:
                return False
            
    return True

a = int(input())
case = []
for i in range(a):
    c = int(input())
    case.append(c)
    
for ca in case :
    A,B = int(ca/2) ,int(ca/2)
    for i in range(int(ca/2)):
        if sosu(A) and sosu(B):
            print(A,B)
            break
            
        else :
            A -= 1
            B += 1