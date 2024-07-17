class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = {0,0};
        int maxWid = board[0] / 2;
        int maxLen = board[1] / 2;
        for(String str : keyinput){
            switch(str){
                case "up":
                    if(answer[1] < maxLen) answer[1]++;
                    break;
                case "down":
                    if(answer[1] > -maxLen) answer[1]--;
                    break;
                case "left":
                    if(answer[0] > -maxWid) answer[0]--;
                    break;
                case "right":
                    if(answer[0] < maxWid) answer[0]++;
                    break;
            }
        }
        return answer;
    }
}