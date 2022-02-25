import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static int N, M, H;
    public static int[][][] arr;
    public static int max;
    public static int cnt;
    public static Queue<int[]> que;

    public static void bfs(int y, int x, int z) {
        int[] dy = { 0, 1, 0, -1, 0, 0 }; // 좌우 상하
        int[] dx = { -1, 0, 1, 0, 0, 0 };
        int[] dz = { 0, 0, 0, 0, -1, 1 }; // 위아래..
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arr[i][j][k] == 1) { //토마토 넣기
                        que.add(new int[]{i, j,k, arr[i][j][k] });
                    }
                }
            }
        }
        while (!que.isEmpty()) { //토마토...익히기
            int[] add = new int[3];
            add = que.poll();
            int ptrZ = add[0];
            int ptrY = add[1];
            int ptrX = add[2];
            cnt = add[3];
            for (int i = 0; i < 6; i++) { //6방탐색
                int ny = ptrY + dy[i];
                int nx = ptrX + dx[i];
                int nz = ptrZ + dz[i];
                if (ny >= N || nx >= M || ny < 0 || nx < 0 || nz >=H || nz<0)//범위쳌
                    continue;
                if (arr[nz][ny][nx] == 0) { // 이동한 좌표가 0이라면
                    arr[nz][ny][nx] = add[3] + 1;
                    que.add(new int[] { nz, ny,nx, arr[nz][ny][nx] });
                }
            }
            max = Math.max(max, add[3]);
        }
    }

    public static void main(String[] args) throws IOException {
        // =============================input=============================
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int[H][N][M];
        que = new LinkedList<>();
        max = 0;
        for (int i = 0; i < H; i++) { //토마토 상자 만들기
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(bf.readLine());
                for (int k = 0; k < M; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
        // =============================sol=============================
        bfs(0, 0, 0); //탐색 시작
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arr[i][j][k] == 0) { //다 익었는데 안익은 토마토가 있나?
                        max = 0;
                    }
                }
            }
        }
        // =============================output=============================
        System.out.println(max - 1);
    }
}
