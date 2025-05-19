import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			
			int answer = (int)checker(N,R);
			
			bw.write("#" +(t+1) + " " +answer +"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	public static long checker(int N, int R) {
	    int MOD = 1234567891;
	    
	    if (R == 0 || R == N) return 1;
	    if (R > N) return 0;
	    
	    int tmp = N - R;
	    R = Math.min(tmp, R);
	    
	    long numerator = 1;
	    long denominator = 1;
	    
	    for (int i = 0; i < R; i++) {
	        numerator = (numerator * (N - i)) % MOD;
	        denominator = (denominator * (R - i)) % MOD;
	    }
	    
	    // Calculate denominator^(MOD-2) % MOD (modular inverse)
	    long inverse = modPow(denominator, MOD - 2, MOD);
	    return (numerator * inverse) % MOD;
	}

	public static long modPow(long base, long exp, int mod) {
	    long result = 1;
	    while (exp > 0) {
	        if ((exp & 1) == 1) {
	            result = (result * base) % mod;
	        }
	        base = (base * base) % mod;
	        exp >>= 1;
	    }
	    return result;
	}

}
