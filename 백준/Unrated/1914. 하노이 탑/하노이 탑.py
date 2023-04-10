a = int(input())

def hanoi (num, start, to, end):
    if num == 1:
        print(start,end)
        return
    elif num > 20:
        return
    else :
        hanoi(num -1, start,end, to)
        print(start, end)
        hanoi(num-1, to, start, end)

print(2**a -1)        
hanoi(a,1,2,3)