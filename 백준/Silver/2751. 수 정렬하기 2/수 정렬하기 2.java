

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        for(int i= 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        StringBuilder sb = new StringBuilder();

        Arrays.sort(arr);

        for(int i = 0; i < arr.length; i++){
            sb.append(arr[i]).append("\n");
        }
        

        bw.write(sb.toString());
        bw.close();
        br.close();

    }
}
