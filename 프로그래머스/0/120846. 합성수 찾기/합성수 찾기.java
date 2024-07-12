import java.util.*;
class Solution {
    public int solution(int n) {
        // 먼저 소수를 판단해보자.
        List<Integer> primes = new ArrayList<>();
        primes.add(2); 
        for(int i = 3; i <= n; i+= 2){
            boolean checkPrime = true;
            for(int prime : primes){
                if(prime > Math.sqrt(i))
                    break;
                if(i % prime == 0){
                    checkPrime = false;
                    break;
                }
            }
            if(checkPrime){
                primes.add(i);
            }
        }
        if(n == 1){
            return 0;
        }
        else{
            int m = primes.size()+1;
            return n - m;
        }
    }
}