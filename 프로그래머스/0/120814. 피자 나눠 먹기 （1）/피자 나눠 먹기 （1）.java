class Solution {
    public int solution(int n) {
        int answer;
        // n을 7로 나누고 +1
        if(n % 7 == 0){
            answer = n/7;
        }
        else{
            answer  = (n/7) +1;
        }
        return answer;
    }
}