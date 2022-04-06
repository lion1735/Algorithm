import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 브루트포스??
// 백트랙킹??

public class Main_2239_최강 {
    public static int arr[][];

    public static boolean rectCheck(int y, int x) { // 상자 체크
        boolean visited[] = new boolean[10];
        for (int i = y; i < y + 3; i++) {
            for (int j = x; j < x + 3; j++) {
                if (arr[i][j] == 0)
                    continue;
                if (visited[arr[i][j]])
                    return false;
                visited[arr[i][j]] = true;
            }
        }
        return true;
    }

    public static boolean check() { // 전체 체크
        for (int i = 0; i < 9; i++) { // 가로 체크
            boolean visited[] = new boolean[10];
            for (int j = 0; j < 9; j++) {
                if (arr[i][j] == 0)
                    continue;
                if (visited[arr[i][j]])
                    return false;
                visited[arr[i][j]] = true;
            }
        }
        for (int i = 0; i < 3; i++) { // 상자 체크
            for (int j = 0; j < 3; j++) {
                if (!rectCheck(3 * i, 3 * j)) {
                    return false;
                }
            }
        }
        for (int i = 0; i < 9; i++) { // 세로 체크
            boolean visited[] = new boolean[10];
            for (int j = 0; j < 9; j++) {
                if (arr[j][i] == 0)
                    continue;
                if (visited[arr[j][i]])
                    return false;
                visited[arr[j][i]] = true;
            }
        }
        return true;
    }

    static boolean numCheck(int ny, int nx, int isNum) { // 해당 부분만 체크
        for (int i = 0; i < 9; i++) {
            if (arr[i][nx] == isNum) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (arr[ny][i] == isNum) {
                return false;
            }
        }
        int py = ny - ny % 3;
        int px = nx - nx % 3;
        for (int i = py; i < py + 3; i++) {
            for (int j = px; j < px + 3; j++) {
                if (arr[i][j] == isNum) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void recur(int y, int x) {
        if (!check()) // 전체 체크
            return;
        if (x == 9) {
            y += 1;
            x = 0;
        }
        if (y == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(arr[i][j]);
                }
                sb.append('\n');
            }
            System.out.println(sb);
            System.exit(0);
        }
        if (arr[y][x] != 0) {
            recur(y, x + 1);
        } else {
            for (int i = 1; i < 10; i++) {
                if (numCheck(y, x, i)) { // 해당하는 숫자가 속해있는 부분만 체크
                    arr[y][x] = i;
                    recur(y, x + 1);
                    arr[y][x] = 0;
                }
            }
        }

    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String s = bf.readLine();
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(s.substring(j, j + 1));
            }
        }
        recur(0, 0);
    }
}
