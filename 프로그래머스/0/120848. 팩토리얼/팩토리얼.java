class Solution {
    public int solution(int n) {
        int result =1;
        int answer = 0;
        for(int i = 1; i <= 10; i++){
            result *= i;
            if(result == n){
                answer = i;
                break;
            }
            if(result > n){
                answer = i-1;
                break;
            }
        }
        return answer;
    }
}