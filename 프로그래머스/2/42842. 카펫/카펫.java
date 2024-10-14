class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int col = 3;
        int n = brown + yellow;
        while(col != n){
            int row = n / col;
            if(row >= 3 && row >= col){
                if((row-2) * (col-2) == yellow){
                    answer[0] = row;
                    answer[1] = col;
                    break;
                }
            }
            col++;
        }
        return answer;
    }
}