

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Product {
        int w;
        int v;

        public Product(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Product> list = new ArrayList<>();


        for(int i = 0; i < N; i++ ) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.add(new Product(w, v));
        }

        int[][] dp = new int[N + 1][K + 1];

        for(int i = 1; i <= N; i++) {
            Product product = list.get(i-1);

            for(int j = 0; j <= K; j++) {
               dp[i][j] = dp[i-1][j];
               if(j >= product.w) {
                   dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-product.w]+ product.v);
               }
            }
        }

        bw.write(String.valueOf(dp[N][K]));
        bw.close();
        br.close();
    }
}
