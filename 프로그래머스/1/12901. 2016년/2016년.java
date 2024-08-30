class Solution {
    
    public String solution(int a, int b) {
        // 1월 1일 
        // a월 b일은 무슨 요일일까?
        int day = 0;
        int[] daysInMonth = {0,31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] week = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        // 5 24 
        for(int i = 1; i <= a-1; i++){
            day += daysInMonth[i];
        }
        day += b;
        // 3 + 6 = 9 % 7
        return week[(day+4)% 7];
    }
}