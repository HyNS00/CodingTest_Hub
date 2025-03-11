import java.util.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
    
        int answer = 0;
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        
        for(int i = 1; i < arrayA.length; i++){
            gcdA = gcd(gcdA,arrayA[i]);
            gcdB = gcd(gcdB,arrayB[i]);
        }
        
        boolean validA = true;
        boolean validB = true;
        
        for(int i = 0; i < arrayA.length; i++){
            if(arrayA[i] % gcdB == 0){
                validB = false;
                break;
            }
        }
        
        for(int i = 0; i < arrayB.length; i++){
            if(arrayB[i] % gcdA == 0){
                validA = false;
                break;
            }
        }
        
        if(validA){
            answer = Math.max(answer,gcdA);
        }
        if(validB){
            answer = Math.max(answer,gcdB);
        }
        
        return answer;
    }
    private int gcd(int a, int b){
        
        while(b != 0){
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}