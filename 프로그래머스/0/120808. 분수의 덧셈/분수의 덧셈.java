class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int upper = (denom1 * numer2) +(denom2 * numer1);
        int under = denom1 * denom2;
        
        int[] answer = new int[2]; // 길이가 2인 배열
        int max = 1;
        int common = 1;
        while(common <= upper && common <= under){
            if(upper % common == 0 && under % common == 0){
                max = common;
            }
            common += 1;
        }
        
        answer[0] = upper / max;
        answer[1] = under / max;
        return answer;
    }
}