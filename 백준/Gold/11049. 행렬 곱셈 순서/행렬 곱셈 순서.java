
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] matrix = new int[n][2];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            matrix[i][0] = a;
            matrix[i][1] = b;
        }

        int[][] multiply = new int[n][n];
        for(int i = 0; i < n-1; i++) {
            multiply[i][i + 1] = matrix[i][0] * matrix[i][1] * matrix[i + 1][1];
        }

        for(int i = 2; i < n; i++) {
            for(int j = 0; j + i < n; j++) {
                multiply[j][i + j] = Integer.MAX_VALUE;
                for(int k = j; k < i+j; k++) {
                    multiply[j][i+j] = Math.min(
                            multiply[j][i+j] ,
                            multiply[j][k] + multiply[k+1][i+j] + matrix[j][0] * matrix[k][1] * matrix[j+i][1]
                    );
                }
            }
        }
        bw.write(String.valueOf(multiply[0][n - 1]));
        bw.close();
        br.close();
    }
}
