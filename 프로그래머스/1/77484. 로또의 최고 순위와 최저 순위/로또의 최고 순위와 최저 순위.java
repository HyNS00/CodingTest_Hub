class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int cnt = 0;
        int hide = 0;
        for(int i = 0; i < lottos.length; i++){
            for(int j = 0; j < win_nums.length; j++){
                if(lottos[i] > 0 && lottos[i] == win_nums[j]){
                    cnt++;
                }
            }
            if(lottos[i] == 0){
                hide++;
            }
        }
        answer[0] = rate(cnt+hide);
        answer[1] = rate(cnt);
        return answer;
        
    }
    private int rate(int count){
        int result = 0;
        switch(count){
            case 6:
                result = 1;
                break;
            case 5 :
                result = 2;
                break;
            case 4 :
                result = 3;
                break;
            case 3 :
                result = 4;
                break;
            case 2 :
                result = 5;
                break;
            default :
                result = 6;
                break;
        }
        return result;
    }
}