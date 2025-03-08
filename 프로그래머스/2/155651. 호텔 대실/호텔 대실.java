import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        // 순서가 정해져있다 , 혹은 빠르게 -> 큐를 생각해보자.
        // 그리고 가장 일찍 끝나는 방과 다음 시간을 비교해보자
        // 나오는 것에도 순서가 있다. -> 우선 순위 큐
        Comparator<String[]> comparator = (a,b) -> a[0].compareTo(b[0]);
        PriorityQueue<String[]> pq = new PriorityQueue<>((a,b) -> a[1].compareTo(b[1]));
        Arrays.sort(book_time,comparator);
        pq.add(book_time[0]);
        for(int i = 1; i < book_time.length; i++){
            String[] next = book_time[i];
            int nextTime = changer(next[0]);
            if(!pq.isEmpty()){
                int curr = changer(pq.peek()[1]) + 10;
                if(curr > nextTime){
                    pq.add(next);
                }else{
                    pq.poll();
                    pq.add(next);
                }
            }else{
                pq.add(next);
            }
        }
        return pq.size();
    }
    private int changer(String t){
        String[] tmp = t.split(":");
        int result = Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]);
        if (result >= 1439){
            return 1439;
        }else{
            return result;
        }
    }
}