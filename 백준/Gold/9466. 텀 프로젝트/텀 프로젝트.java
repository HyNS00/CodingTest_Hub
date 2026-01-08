import java.io.*;
import java.util.*;

public class Main {
    static int cnt;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for(int t = 0; t < testCase; t++) {
            cnt = 0;
            int n = Integer.parseInt(br.readLine());
            int[] state = new int[n + 1];
            int[] choice = new int[n + 1];


            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= n; i++) {

                choice[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 1; i <= n; i++) {
                if (state[i] == 0) {
                    dfs(i,state,choice);
                }
            }

            sb.append(n - cnt).append("\n");

        }
        bw.write(sb.toString());
        bw.close();
        br.close();

    }
    private static void dfs(int number,int[] state,int[] choice) {
        state[number] = 1;

        int next = choice[number];

        if(state[next] == 0) {
            dfs(next,state,choice);
        }else if(state[next] == 1) {
            int node = next;
            do {
                cnt++;
                node = choice[node];
            }while (next != node);
        }
        state[number] = 2;
    }
}
