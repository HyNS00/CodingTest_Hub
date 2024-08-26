import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        List<Integer> wList = new ArrayList<>();
        List<Integer> hList = new ArrayList<>();
        // 큰 값들 중 가장 큰 것 작은 값들 중 가장 큰 것
        // 
        for(int i = 0; i < sizes.length; i++){
            wList.add(Math.max(sizes[i][0],sizes[i][1]));
            hList.add(Math.min(sizes[i][0],sizes[i][1]));
        }
        int w = Collections.max(wList);
        int h = Collections.max(hList);
        return w * h;
    }
}