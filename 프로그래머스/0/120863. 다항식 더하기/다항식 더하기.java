class Solution {
    public String solution(String polynomial) {
        String[] tmp = polynomial.replace(" ","").split("\\+");
        // +은 정규식에서 의미를 가지므로 이스케이프 문자를 사용해야한다.
        int num = 0;
        int cnt = 0;
        String answer = "";
        for(String str : tmp){
            if(str.contains("x")){
                if(str.length() > 1){
                    String coef = str.replace("x","");
                    cnt += Integer.parseInt(coef);
                }else{
                    cnt +=1;
                }
                    
            }else{
                num += Integer.parseInt(str);
            }
        }
        if(num == 0){
            if(cnt == 1){
                return answer = "x";
            }
            return answer = String.valueOf(cnt)+"x";
        } else if (cnt == 0){
            return answer = String.valueOf(num);
        }else{
            if(cnt == 1){
                return answer = "x + " + String.valueOf(num);
            }
            return answer = String.valueOf(cnt) + "x + " + String.valueOf(num);
        }
    }
}