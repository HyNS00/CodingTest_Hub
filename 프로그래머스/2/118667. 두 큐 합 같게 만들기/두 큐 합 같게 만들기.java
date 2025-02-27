import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        ArrayDeque<Integer> q1 = new ArrayDeque<>();
        ArrayDeque<Integer> q2 = new ArrayDeque<>();
        
        int cnt = 0;
        long sumA = 0, sumB = 0;
        for(int i = 0; i < queue1.length; i++){
            q1.add(queue1[i]);
            q2.add(queue2[i]);
            
            sumA += queue1[i];
            sumB += queue2[i];
        }
        // 매번 스트림을 통해 큐의 합계를 구하는건 낭비
        // 미리 구해놓고 계산 
        int n = queue1.length;
        long total = sumA + sumB;
        if(total % 2 == 1) return -1;
        long target = total / 2;
        // 무한 루프 방지를 위해 최대 반복횟수를 지정한다.
        while(target != sumA && cnt <= n * 3){
            if(sumA > sumB){
                int e = q1.poll();
                q2.offer(e);
                sumA -= e;
                sumB += e;
                cnt++;
            }else if(sumB > sumA){
                int e = q2.poll();
                q1.offer(e);
                sumA += e;
                sumB -= e;
                cnt++;
            }
        }
        return target == sumA ? cnt : -1;
    }
}