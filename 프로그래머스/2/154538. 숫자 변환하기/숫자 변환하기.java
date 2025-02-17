import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        // 반복에서 백트래킹을 찾는 것도 좋은 접근이었지만,
        // 최소 연산을 보고 bfs를 떠올리는 게 중요했다.
        // 그리고 각 연산에 대해 배열에 접근하는 법을 생각하자.
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        Set<Integer> visit = new HashSet<>();
        // 중복계산을 피하기 위해 계산해서 나온 값들을 모아두는 리스트
        queue.offer(new int[]{x,0});
        visit.add(x);
        if(y == x) return 0;
        while(!queue.isEmpty()){
            int[] ele = queue.poll();
            int num = ele[0];
            int cnt = ele[1];
            
            int[] cals = {num* 2 , num * 3, num + n};
            // 배열로 각각 계산할 식을 미리 넣어놓는 것을 기억하자.
            
            for(int cal : cals){
                if(cal  == y){
                    return cnt+1;
                }
                if(cal < y && !visit.contains(cal)){
                    queue.offer(new int[] {cal,cnt+1});
                    visit.add(cal);
                }
            }
        }
        return -1; // 반복문에서 반환이 있으니 여기서는 실패 했을 때를 반환하는 것을 기억.
    }
}