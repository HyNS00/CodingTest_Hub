a = int(input())
for i in range(a):
    score = 0
    sum_i = 0
    ox_list = list(input())
    
    for ox in ox_list :
        if ox == 'O' :
            score += 1
            sum_i += score
            
        else :
            score = 0
    print(sum_i)
