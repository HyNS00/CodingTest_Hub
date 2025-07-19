
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());
        char[] tmp = String.valueOf(factorial(n)).toCharArray();
        int cnt = 0;
        for(int i = tmp.length -1; i >= 0; i--){
            if(tmp[i] == '0'){
                cnt++;
            }else if(tmp[i] != '0'){
                break;
            }
        }
        bw.write(cnt + "\n");
        bw.close();
        br.close();
    }

    public static BigInteger factorial(int n){
        // 팩토리얼은 20만 넘어도 long 크기 벗어남
        BigInteger result = BigInteger.ONE;

        for(int i = 2; i <= n; i++){
            result = result.multiply(BigInteger.valueOf(i));
        }
        // BigInteger
        /*
            BigInteger의 인스턴스 메서드
              add : 덧셈  bi.add(BigInteger)
              subtract : 뺼셈 bi.subtract(BigInteger)
              multiply : 곱셈 bi.multiply(BigInteger)
              divide : 나눗셈 bi.divide(BigInteger)
              remainder : 나머지 bi.remainder(BigInteger)
              pow : 제곱 bi.pow(n)


         */
        return result;
    }
}
