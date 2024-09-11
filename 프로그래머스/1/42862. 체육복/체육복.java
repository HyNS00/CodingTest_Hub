import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] student = new int[n];
        int cnt=0;
        Arrays.fill(student,1);
        for(int l : lost){
            student[l-1]--;
        }
        for(int r : reserve){
            student[r-1]++;
        }
        for(int i = 0; i < student.length; i++){
            if(student[i] == 0){
                if(i > 0 && student[i-1]== 2){
                    student[i]++;
                    student[i-1]--;
                }else if(i+1 < n && student[i+1] == 2){
                    student[i]++;
                    student[i+1]--;
                }
            }
        }
        for(int s : student){
            if(s > 0){
                cnt++;
            }
        }
        return cnt;
    }
}