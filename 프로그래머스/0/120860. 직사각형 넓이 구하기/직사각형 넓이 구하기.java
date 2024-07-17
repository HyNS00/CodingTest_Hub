class Solution {
    public int solution(int[][] dots) {
        int maxWid = dots[0][0];
        int minWid = dots[0][0];
        int maxLen = dots[0][1];
        int minLen = dots[0][1];
        
        for(int i = 1; i < dots.length; i++){
            maxWid = Math.max(maxWid, dots[i][0]);
            minWid = Math.min(minWid, dots[i][0]);
            maxLen = Math.max(maxLen, dots[i][1]);
            minLen = Math.min(minLen, dots[i][1]);
        }
        int width = maxWid - minWid;
        int length = maxLen - minLen;
        return width * length;
    }
}