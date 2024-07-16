class Solution {
    public int solution(String str1, String str2) {
        String tmp = str1.replace(str2,"");
        if(tmp.length() != str1.length()){
            return 1;
        }else{
            return 2;
        }
    }
}