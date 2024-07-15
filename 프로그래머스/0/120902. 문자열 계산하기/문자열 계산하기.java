class Solution {
    public int solution(String my_string) {
        //[3,+,3,-,4,+,5,-,9]
        //[0,1,2,3,4,5,6,7,8]
        String[] tmp = my_string.split(" ");
        int n = tmp.length;
        int a = Integer.parseInt(tmp[0]);
        int b = Integer.parseInt(tmp[2]);
        int cal = 0;
        if(tmp[1].equals("+")){
            cal = a+b;
        }else{
            cal = a-b;
        }
         if(n > 3){
            for(int i = 3; i < n; i+=2){
                if(tmp[i].equals("+")){
                    cal = cal + Integer.parseInt(tmp[i+1]);
                }else{
                    cal = cal - Integer.parseInt(tmp[i+1]);
                }
            }
        }
        return cal;
    }
}