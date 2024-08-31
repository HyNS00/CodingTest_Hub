import java.util.stream.*;
class Solution {
    public int solution(int number, int limit, int power) {
        // List<Integer> list = new ArrayList<>();
        int test= IntStream.rangeClosed(1,number).map(num ->{
            if(check(num) > limit){
                return power;
            }else{
                return check(num);
            }
        }).sum();
        return test;
    }
    private int check(int num){
        int cnt = 0;
        if(num == 1) return 1;
        for(int i = 1; i * i <= num; i++){
            if(num % i == 0){
                if(i * i == num){
                    cnt+=1;
                }else{
                    cnt+=2;
                }
            }
        }
        return cnt;
    }
}