import java.util.*;
class Solution {
    // 그룹 수를 지정하지 않으면 안된다.
    public int solution(int[] picks, String[] minerals) {
        List<int[]> list = new ArrayList<>();
        int total = picks[0] + picks[1] + picks[2];
        int groupCount = Math.min((minerals.length + 4)/5, total);
        int n = minerals.length;
        int idx = 0;
        int cnt = 0;
        while(idx < n && cnt < groupCount){
            int[] tmp = new int[3];
            for(int i = idx; i < idx+5 && i < n; i++){
                if(minerals[i].equals("diamond")){
                    tmp[0]++;
                }else if(minerals[i].equals("iron")){
                    tmp[1]++;
                }else {
                    tmp[2]++;
                }
            }
            list.add(tmp);
            cnt++;
            idx += 5;
        }
        
        Comparator<int[]> comp = Comparator.comparingInt((int[] a) -> -a[0])
            .thenComparingInt((int[] a) -> -a[1]).thenComparingInt((int[] a) -> -a[2]);
        list.sort(comp);
        int answer = 0;
        for(int[] group : list){
            if(picks[0] > 0){
                answer += group[0]+group[1]+group[2];
                picks[0]--;
            }else if(picks[1] > 0){
                answer += group[0] * 5 + group[1] + group[2];
                picks[1]--;
            }else {
                answer += group[0] * 25 + group[1] * 5 + group[2];
                picks[2]--;
            }
        }
        return answer;
    }
    
}