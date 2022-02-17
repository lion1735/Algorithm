import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.zip.CheckedInputStream;
import java.io.IOException;

public class Main {
    static int N, M, res, max;
    static int[] dy = { -1, 0, 1 };
    static char[][] map;
    static boolean visited;
    static StringBuilder sb;

    // ===================recur===================
    static boolean recur(int y, int x) {
        // for (char[] c : map) {
        //     for (char d : c) {
        //         System.out.printf("%c ", d);
        //     }
        //     System.out.println();
        // }
        // System.out.println("---------------------------");
        if (x == M - 1) { // 찾은 경우
            res++;
            visited = true;
            return true; //찾았을때는 반복문을 탈출
        }

        for (int i = 0; i < 3; i++) {
            int ny = y + dy[i];
            int nx = x + 1;
            if (ny < 0 || nx < 0 || ny >= N || nx >= M || map[ny][nx] == 'x' || visited) //범위 체크
                continue;
            map[ny][nx] = 'x';
            if (recur(ny, nx))
                break;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        // ===================input===================
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = bf.readLine().toCharArray();
        }
        // ===================sol===================
        res = 0;
        for (int i = 0; i < N; i++) {
            visited = false;
            recur(i, 0);
        }
        // ===================output===================
        System.out.println(res);
    }
}
