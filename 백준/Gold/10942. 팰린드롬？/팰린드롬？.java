
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            decider(start, end, arr);

        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
    private static void decider(int start, int end, int[] arr) {
        int st = start-1;
        int e = end -1;

        if(st == e) {
            sb.append(1).append("\n");
            return;
        }
        boolean flag = true;
        while(e >= st && st < arr.length && e >= 0) {
            if(arr[st] == arr[e]) {
                st++;
                e--;

            }else {
                flag = false;
                break;
            }
        }
        if(flag) {
            sb.append(1).append("\n");
        }else {
            sb.append(0).append("\n");
        }

    }
}
