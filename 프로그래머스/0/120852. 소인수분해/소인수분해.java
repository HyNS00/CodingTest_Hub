import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int n) {
        // n이하의 소수를 구한다.
        // 소수 중 약수를 찾아본다.
        List<Integer> primes = new ArrayList<>();
        List<Integer> divisor = new ArrayList<>();
        primes.add(2);
        for(int numbers = 3; numbers <= n; numbers+=2){
            boolean check = true;
            for(int prime : primes){
                if(prime * prime > numbers) break;
                if(numbers % prime == 0){
                    check = false;
                    break;
                }
            }
            if(check){
                primes.add(numbers);
            }
        }
        for(int tmp :primes){
            if(n % tmp == 0){
                divisor.add(tmp);
            }
        }
        return divisor.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}