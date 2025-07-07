
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int M  = Integer.parseInt(st.nextToken());

        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int answer = 0;
        for(int i = 0; i < arr.length-2; i++){
            for(int j = i+1; j < arr.length -1; j++){
                for(int p = j+1; p < arr.length; p++){
                    // 중복을 방지하기 위해서 
                    int sum = arr[i] + arr[j] + arr[p];
                    if(sum <= M && sum > answer){
                        answer = sum;
                    }
                }
            }
        }
        bw.write(answer + "\n");
        bw.close();
        br.close();
    }

}
