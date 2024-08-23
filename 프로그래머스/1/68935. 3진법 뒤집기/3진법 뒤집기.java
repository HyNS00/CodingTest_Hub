class Solution {
    public int solution(int n) {
        String tmp = Integer.toString(n, 3); //1200
        StringBuilder sb = new StringBuilder(tmp);
        sb.reverse(); // 0021
        return Integer.parseInt(sb.toString(),3);
        
        // 22111
        //  54931
    }
}