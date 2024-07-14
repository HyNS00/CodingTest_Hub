class Solution {
    public String solution(String cipher, int code) {
        String[] tmp = cipher.split("");
        int n = tmp.length;
        StringBuilder sb = new StringBuilder();
        for(int i = code-1; i < n; i+= code){
            sb.append(tmp[i]);
        }
        return sb.toString();
    }
}