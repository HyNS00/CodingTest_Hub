import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    static class Assign{
        String name;
        int start;
        int play;

        public Assign(String name, int start, int play) {
            this.name = name;
            this.start = start;
            this.play = play;
        }

    }
    public String[] solution(String[][] plans){
        PriorityQueue<Assign> pq = new PriorityQueue<>((a,b) -> a.start - b.start);
        List<String> list=  new ArrayList<>();
        ArrayDeque<Assign> wait = new ArrayDeque<>();

        for(String[] plan : plans){
            pq.add(maker(plan));
        }
        int now = 0;
        // 시간에 맞춰서
        while(!pq.isEmpty()){
            Assign curr = pq.poll();
            now = curr.start;

            if(!pq.isEmpty()){
                if(now + curr.play < pq.peek().start) {
                    now += curr.play;
                    list.add(curr.name);
                    while (!wait.isEmpty()) {
                        Assign remainAssign = wait.pop();
                        if (remainAssign.play + now <= pq.peek().start) {
                            now += remainAssign.play;
                            list.add(remainAssign.name);
                            // continue; 어차피 else로 안가니까 불 필요
                        } else {
                            remainAssign.play = remainAssign.play + now - pq.peek().start;
                            wait.push(remainAssign);
                            break;
                        }
                    }
                } else if(now + curr.play == pq.peek().start){
                    list.add(curr.name);

                }else {
                    curr.play = now + curr.play - pq.peek().start;
                    wait.push(curr);
                }
            }else {
               list.add(curr.name);
               while(!wait.isEmpty()){
                   list.add(wait.pop().name);
               }
            }
        }
        return list.toArray(new String[0]);
    }
    
    private Assign maker(String[] plan){
        String[] tmp = plan[1].split(":");
        int st = Integer.parseInt(tmp[0]) * 60  + Integer.parseInt(tmp[1]);
        return new Assign(plan[0], st, Integer.parseInt(plan[2]));
    }
}
