

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];

        for(int i = 0; i < arr.length; i++){
            arr[i] = br.readLine();
        }

        Comparator<String> comp = Comparator.comparing(String::length)
                .thenComparing(Comparator.naturalOrder());

        // Comparator.naturalOrder() -> 원래 오름차순 정렬

        Arrays.sort(arr,comp);

        StringBuilder sb = new StringBuilder();
        Arrays.stream(arr).distinct().forEach(str -> sb.append(str).append("\n"));

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
