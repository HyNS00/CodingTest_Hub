class Solution {
    public String solution(String s, int n) {
        char[] tmp = s.toCharArray();
        
        for(int i = 0; i < tmp.length; i++) {
            if(!Character.isLetter(tmp[i])) continue;
            char target = tmp[i];
            
            if(target >= 'a' && target <= 'z') {
                int standard = 97;
                tmp[i] = (char) (((target + n) % standard % 26) + standard);
            }else {
                int standard = 65;
                tmp[i] = (char) (((target + n) % standard % 26) + standard);
            }
        }
        return new String(tmp);
    }
}