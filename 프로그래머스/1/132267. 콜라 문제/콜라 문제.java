class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(n >= a){
            int cola = (n/a) * b;
            answer += cola;
            n = cola + n % a;
            if(2 > n) break;
        }
        return answer;
    }
}