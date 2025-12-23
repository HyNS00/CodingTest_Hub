
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String first = br.readLine();
        String second = br.readLine();

        // lcs는 일단 순서가 연속이진 않아도, 구성은 연속이어야한다.
        int n = first.length();
        int m = second.length();

        int[][] dp = new int[n+1][m+1];
        // lcs에서 같은 값이면 추가하면 된다. 하지만 다르면 둘 중 하나만 추가한다.
        for(int i = 1; i <= n; i++) {
            for(int j= 1; j <= m; j++) {
                if(first.charAt(i-1) == second.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        // 역추적

        if(dp[n][m] == 0) {
            bw.write("0");

        }else {
            bw.write(dp[n][m]+"\n"+finder(dp,first,second));

        }
        bw.close();
        br.close();
    }
    public static String finder(int[][] dp, String first, String second) {
        StringBuilder sb = new StringBuilder();

        int i = first.length();
        int j = second.length();

        while(i > 0 && j > 0){
            if(first.charAt(i-1) == second.charAt(j-1)) {
                sb.append(first.charAt(i-1));
                i--;
                j--;
            }else if (dp[i-1][j] > dp[i][j-1]) {
                i--;
            }else {
                j--;
            }
        }
        return sb.reverse().toString();
    }
}
