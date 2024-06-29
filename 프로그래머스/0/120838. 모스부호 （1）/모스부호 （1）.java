class Solution {
    public String solution(String letter) {
         String[] morse ={
              ".-","-...","-.-.","-..",".","..-.",
              "--.","....","..",".---","-.-",".-..",
              "--","-.","---",".--.","--.-",".-.","...","-",
              "..-","...-",".--","-..-","-.--","--.."
          };
         String[] letterword = letter.split(" ");
         StringBuilder sb = new StringBuilder();
         for(String word : letterword){
             for(int i = 0; i < morse.length; i++){
                 if(word.equals(morse[i])){
                     sb.append((char) (i+'a'));
                 }
             }
         }
        return sb.toString();
    }
}