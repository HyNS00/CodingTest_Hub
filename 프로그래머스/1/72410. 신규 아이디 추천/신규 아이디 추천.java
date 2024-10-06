class Solution {
    public String solution(String new_id) {
        String tmp = new_id.toLowerCase();
        tmp = tmp.replaceAll("[^0-9a-z\\-_.]","");
        for(int i = 0; i < tmp.length(); i++){
            if(i+1 < tmp.length() && tmp.charAt(i) == '.' && tmp.charAt(i+1) =='.'){
                tmp = tmp.substring(0,i+1) + tmp.substring(i+2);
                i--;
            }
        }
        if(!tmp.isEmpty() && tmp.charAt(0) == '.'){
            tmp = tmp.substring(1);
        }
        if(!tmp.isEmpty() &&tmp.charAt(tmp.length()-1) == '.'){
            tmp = tmp.substring(0,tmp.length()-1);
        }
        if(tmp.isEmpty()){
            tmp = "a";
        }
        if(tmp.length() >= 16){
            tmp = tmp.substring(0,15);
            if(tmp.charAt(14) == '.'){
                tmp = tmp.substring(0,14);
            }
        }
        while(tmp.length() <= 2){
            tmp += tmp.charAt(tmp.length() - 1);
        }
        return tmp;
    }
}