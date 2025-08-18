
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int K = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[] array = Arrays.stream(arr).boxed().sorted((a, b) -> b - a)
                .mapToInt(x -> x)
                .toArray();
        bw.write(String.valueOf(checker(array, K)));
        bw.close();
        br.close();
    }
    private static int checker(int[] arr, int target){
        int result = 0;

        for(int coin : arr){
            if(coin > target){
                continue;
            }
            result += target / coin;
            target %= coin;

            if(target <= 0){
                break;
            }
        }
        return result;

    }
}
