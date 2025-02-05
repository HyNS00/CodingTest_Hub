import java.util.*;
class Solution {
    private List<String> dict = new ArrayList<>();
    public int solution(String word) {
        char[] words = {'A','E','I','O','U'};
        make("",5,words);
        return dict.indexOf(word);
    }
    private void make(String str, int n, char[] words){
        dict.add(str);
        
        if(str.length() == n){
            return;
        }
        
        for(char c : words){
            make(str+c,n,words);
        }
    }
}