import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.zip.CheckedInputStream;
import java.io.IOException;

public class Main {
    static int N,M, res,max;
    static int [] dy ={-1,1,0,0};
    static int [] dx ={0,0,-1,1};
    static char[] alpha;
    static char[][] map;
    static boolean []visited; //알파벳 아스키코드는 65-97
    // ===================recur===================
    static void recur(int y,int x,int cnt) {
        if(visited[map[y][x]-'A']){
            max = Math.max(max,cnt);
            return;
        }
        visited[map[y][x]-'A'] = true; //방문한 적이 없으므로 현재 알파벳 저장
        for(int i=0;i<4;i++){
            int ny = y+dy[i];
            int nx = x+dx[i];
            if(ny < 0 || nx < 0 || ny >=N || nx >= M) continue; //범위 체크
            recur(ny, nx,cnt+1); // 갈수있음
        }
        visited[map[y][x]-'A'] = false; //탐색이 종료되었으니까 현재 알파벳 제거
	}

    public static void main(String[] args) throws IOException {
        // ===================input===================
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean['Z'-'A'+1];
        for(int i=0;i<N;i++){
            map[i] = bf.readLine().toCharArray();
        }
        // ===================sol===================
        recur(0,0,0);
        // ===================output===================
        System.out.println(max);
    }
}
