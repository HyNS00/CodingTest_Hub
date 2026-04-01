

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 펠린드롬은 dp로 구하거나 양옆으로 퍼져나가는걸로 구한다.
        char[] arr = br.readLine().toCharArray();

        int n = arr.length;

        boolean[][] checker = new boolean[n][n];
        // 길아가 1 -> 무조건 펠린드롬
        for(int i = 0; i < n; i++) {
            checker[i][i] = true;
        }
        // 길이가 2
        for(int i = 0; i < n-1; i++) {
            if(arr[i] == arr[i+1]) {
                checker[i][i+1] = true;
            }
        }

        // 길이가 3이상
        for(int len = 3; len <= n; len++) {
            for(int i = 0; i <= n - len; i++) {
                int j = len+i-1;
                if(arr[i] == arr[j] && checker[i+1][j-1]) {
                    checker[i][j] = true;
                }
            }
        }

        // 조각 수를 어떻게 나눌 것인가
        int[] dp = new int[n];
        // dp[i] -> 0부터 i번째까지의 문자열을 조각수로 나누었을 때 최소 그룹

        for(int i = 0; i < n; i++) {
            dp[i] = i+1;
            // 최대 조각수

            for(int j = 0; j <= i; j++) {
                if (checker[j][i]) {
                    if(j == 0) {
                        dp[i] = 1;
                    }else {
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }
        }

        bw.write(String.valueOf(dp[n - 1]));
        bw.close();
        br.close();
        
    }
}
