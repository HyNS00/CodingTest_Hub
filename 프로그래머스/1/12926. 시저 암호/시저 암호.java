class Solution {
    public String solution(String s, int n) {
        // 알파벳 갯수 26
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i ++){
            if(s.charAt(i) == ' '){
                sb.append(" ");
            }else{
                char c = s.charAt(i);
                int base = Character.isUpperCase(c) ? 'A' : 'a';
                char tmp = (char) ((c-base + n) % 26 + base);
                sb.append(tmp);
            }
        }
        return sb.toString();
    }
}