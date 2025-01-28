import java.util.*;
import java.util.stream.*;
class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int curr = timeToCal(pos.split(":"));
        int max = timeToCal(video_len.split(":"));
        int start = timeToCal(op_start.split(":"));
        int end = timeToCal(op_end.split(":"));
        for(String command : commands){
            if(curr >= start && curr <= end){
                curr = end;
            }
            if(command.equals("prev")){
                if(curr < 10){
                    curr = 0;
                }else{
                    curr -= 10;
                }
            }
            if(command.equals("next")){
                if(max - curr < 10){
                    curr = max;
                }else{
                    curr += 10;
                }
            }
            if(curr >= start && curr <= end){
                curr = end;
            }
        }
        return change(curr);
    }    
    private int timeToCal(String[] time){
        return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
    }
    private String change(int curr){
        StringBuilder sb = new StringBuilder();
        int min = curr / 60;
        int sec = curr - (min * 60);
        sb.append(String.format("%02d",min)).append(":").append(String.format("%02d",sec));
        return sb.toString();
    }
}