import java.util.*;
class Solution {
    public int solution(int[] arr) {
        // 최소 공배수와 최대 공약수 사이의 관계를 생각해보자.
        Arrays.sort(arr);
        int result = arr[0];
        for(int i = 1; i< arr.length; i++){
            result = lcm(arr[i],result);
        }
        return result;
    }
    private int lcm(int a, int b){
        return (a*b) /gcd(a,b);
    }
    private int gcd(int a, int b){
        while(b!= 0){
            int tmp = b;
            b = a%b;
            a = tmp;
        }
        return a;
    }
}