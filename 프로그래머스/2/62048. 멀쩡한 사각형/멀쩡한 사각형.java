class Solution {
    public long solution(int w, int h) {
        long W =(long) w;
        long H = (long) h;
        
        long result = gcd(W,H);
        
        return (W*H) - (W+H - result);
    }
    
    private long gcd(long x, long y){
        while(y != 0){
            long tmp = y;
            y = x % y;
            x = tmp;
        }
        return x;
    }
}