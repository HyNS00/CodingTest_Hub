class Solution {
    public int solution(int a, int b) {
        int divisor = gcd(a,b);
        int tmp = b / divisor;
        
        while(tmp % 2 == 0){
            tmp /= 2;
        }
        while(tmp % 5 == 0){
            tmp /= 5;
        }
        if(tmp == 1){
            return 1;
        }else{
            return 2;
        }
    }
    private int gcd(int a ,int b){
        while(b != 0){
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}