class Solution {
    public int[] solution(int n, int m) {
        int[] answer =new int[2];
        int min = Math.min(n,m);
        int max = Math.max(n,m);
        // 최소 공배수
        int r = gcd(min,max);
        int lcd = (n*m) / r;
        answer[0] =r;
        answer[1] = lcd;
        return answer;
    }
    public int gcd(int n, int m){
        while(n != 0){
            int r = m % n;
            m = n;
            n = r;
        }
        return m;
    }
}