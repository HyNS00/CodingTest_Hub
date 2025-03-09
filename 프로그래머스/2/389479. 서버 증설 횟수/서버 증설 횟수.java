import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int cnt = 0;
        int acting = 0;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        for(int i = 0; i < players.length; i++){
            int player = players[i];
            int needServer = player / m;
            while(!queue.isEmpty() && queue.peek()[0] < i){
                int[] e = queue.poll();
                acting -= e[1];
            }
            if(needServer - acting > 0){
                int tmp = needServer - acting;
                queue.add(new int[] {i+k-1,tmp});
                cnt += tmp;
                acting += tmp;
            }
        }
         return cnt;
    }
}