class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        // 좀만 다르게 보자.
        for(int i = 0; i < schedules.length; i++) {
            int target = changer(schedules[i]);
            
            boolean flag = false;
            
            for(int j = 0; j < 7; j++) {
                int nextDay = (startday + j) % 7;
                if(nextDay == 0 || nextDay == 6) {
                    continue;
                }
                if(timelogs[i][j] > target) {
                    flag = true;
                }
            }
            if(!flag) {
                answer++;
            }
        }
        return answer;
    }
    private int changer(int time) {
        int hour = time /100;
        int min = time % 100;
        
        min += 10;
        if(min >= 60) {
            hour++;
            min -= 60;
        }
        return hour * 100 + min;
    }
}