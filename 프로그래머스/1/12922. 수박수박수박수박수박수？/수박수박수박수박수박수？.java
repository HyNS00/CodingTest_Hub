class Solution {
    public String solution(int n) {
        String[] sample = {"수","박"};
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(sample[i % 2]);
        }
        return sb.toString();
    }
}