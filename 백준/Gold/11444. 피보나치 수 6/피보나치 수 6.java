import java.io.*;

public class Main {
    static final long MOD = 1_000_000_007L;
    static long[][] A = {
            {1,1},
            {1,0}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());

        // 분할 정복  + 행렬
        long[][] result = pow(A, n - 1);
        bw.write(String.valueOf(result[0][0]));
        bw.close();
        br.close();
    }
    private static long[][] pow(long[][] matrix, long exp) {
        // 분할 정복
        if (exp == 0) { // 단위 행렬
            return A;
        }
        
        if(exp == 1){
            return matrix;
        }
        long[][] intermediate = pow(matrix, exp / 2);
        if(exp % 2 == 0) {
            return multiply(intermediate, intermediate);
        }else {
            long[][] oneMore = multiply(A, intermediate);
            return multiply(oneMore, intermediate);
        }
    }

    private static long[][] multiply(long[][] a, long[][] b) {
        long[][] result = new long[2][2];
        result[0][0] = (a[0][0] * b[0][0] + a[0][1] * b[1][0]) % MOD;
        result[0][1] = (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % MOD;
        result[1][0] = (a[1][0] * b[0][0] + a[1][1] * b[1][0]) % MOD;
        result[1][1] = (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % MOD;
        return result;
    }
}
