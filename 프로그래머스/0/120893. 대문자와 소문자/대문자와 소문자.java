class Solution {
    public String solution(String my_string) {
        char[] tmp = my_string.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c : tmp){
            if(Character.isUpperCase(c)){
                sb.append(String.valueOf(c).toLowerCase());
            }
            else{
                sb.append(String.valueOf(c).toUpperCase());
            }
        }
        return sb.toString();
    }
}