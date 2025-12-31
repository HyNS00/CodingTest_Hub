

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int number = Integer.parseInt(br.readLine());
        int result = 0;

        // 소수 판정을 해야하고,
        // 그 다음은 어떻게 할 것인가
        List<Integer> list = finder(number);
        int cnt = 0;

        int left = 0;
        int right = 0;
        long sum = 0;
        while(true) {

            if(sum >= number) {
                if(sum == number) cnt++;
                if(left >= list.size()) break;
                sum -= list.get(left);
                left++;
            }else {
                if (right >= list.size()) break;
                sum += list.get(right);
                right++;
            }
        }
        bw.write(String.valueOf(cnt));
        bw.close();
        br.close();
    }
    private static List<Integer> finder(int number) {
        List<Integer> list = new ArrayList<>();
        for(int i = 2; i <= number; i++) {
            if(checker(i)) {
                list.add(i);
            }
        }
        return list;
    }
    private static boolean checker(int number) {
        if(number == 2) return true;
        if(number % 2 == 0) return false;

        for(int i = 3; i <= Math.sqrt(number); i+=2){
            if(number % i == 0) return false;
        }
        return true;
    }
}
