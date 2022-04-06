import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 브루트포스??
// 백트랙킹??

public class Solution_5643_최강 {
    public static int N, M, cnt, res;
    public static int map[][];
    public static boolean visited[];

    public static int upBFS(int v) {
        Queue<Integer> que = new LinkedList<>();
        visited = new boolean[N + 1];
        int cnt = 0;
        visited[v] = true;
        que.add(v);

        while (!que.isEmpty()) {
            int temp = que.poll();
            for (int i = 1; i <= N; i++) {
                if (!visited[i] && map[temp][i] == 1) {
                    visited[i] = true;
                    que.add(i);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static int downBFS(int v) {
        Queue<Integer> que = new LinkedList<>();
        visited = new boolean[N + 1];
        int cnt = 0;
        visited[v] = true;
        que.add(v);

        while (!que.isEmpty()) {
            int temp = que.poll();
            for (int i = 1; i <= N; i++) {
                if (!visited[i] && map[i][temp] == 1) {
                    visited[i] = true;
                    que.add(i);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(bf.readLine());
        for (int tc = 0; tc < T; tc++) {
            res = 0;
            N = Integer.parseInt(bf.readLine());
            M = Integer.parseInt(bf.readLine());
            map = new int[N + 1][N + 1];
            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                int C = Integer.parseInt(st.nextToken());
                int R = Integer.parseInt(st.nextToken());
                map[C][R] = 1;
            }
            for (int i = 1; i <= N; i++) {
                if ((upBFS(i) + downBFS(i)) == N - 1)
                    res++;
            }
            sb.append('#').append(tc + 1).append(' ').append(res).append('\n');
        }
        System.out.println(sb);
    }
}
