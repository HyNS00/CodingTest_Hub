

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        int[] arr = new int[12];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        for(int d = 4; d <=11; d++){
            arr[d] = arr[d-1] +arr[d-2] + arr[d-3];
        }
        for(int i = 0; i < t; i++){
            int tmp = Integer.parseInt(br.readLine());
            sb.append(arr[tmp]).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
