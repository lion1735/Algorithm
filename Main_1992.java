import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    static int N;
    static int[][] map;
    static StringBuilder sb;
    // ===================input===================
    static void recur(int y, int x, int n) {
        if (x > N || 0 > x || y > N || 0 > y) 
            return;
        int temp = map[y][x];
        int ptr = 1;
        //해당 영역에 다른값이 있는지 확인
        for (int i = y; i < y + n; i++) { 
            for (int j = x; j < x + n; j++) {
                if (temp != map[i][j]){
                    ptr = 0;
                    break;
                }
            }
            if(ptr==0) break;
        }
        if (ptr == 1) { //다른 값이 없다면? 압축
            sb.append(temp);
        } else { //다른값이 존재한다면 좌상, 우상, 좌하, 우하 순으로 범위 줄여가며 탐색
            sb.append('(');
            recur(y, x, n / 2);
            recur(y, x+n/2, n / 2);
            recur(y+n/2, x, n / 2);
            recur(y+n/2, x+n/2, n / 2);
            sb.append(')');
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(bf.readLine());
        // ===================input===================
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] s = bf.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = s[j].charAt(0)-48;
            }
        }
        // ===================sol===================
        recur(0, 0, N);
        // ===================output===================
        System.out.println(sb);
    }
}
