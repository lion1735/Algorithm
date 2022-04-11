import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    static long K = 1000000007;

    private static long pow(long a, long b) {
        if (b == 0)
            return 1;

        else if (b == 1)
            return a;

        if (b % 2 == 0) {
            long tmp = pow(a, b / 2);
            return (tmp * tmp) % K;
        }

        long tmp = pow(a, b - 1) % K;
        return (tmp * a) % K;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long[] factorial = new long[40000001];
        factorial[0] = 1;
        factorial[1] = 1;
        for (int i = 2; i <= 40000000; i++) {
            factorial[i] = (factorial[i - 1] * i) % K;
        }
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long result = 1;

        long bottom = (factorial[M] * factorial[N - M]) % K;
        bottom = pow(bottom, K - 2);
        result = (factorial[N] * bottom) % K;
        System.out.println(result);
    }
}
