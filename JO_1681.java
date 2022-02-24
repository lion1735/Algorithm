import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Main {
    static int N, res, ans;
    static boolean[] visited;
    static int map[][];
    // 1-2-4-5-3-1
    // ===================recur===================
    public static void recur(int cnt, int cur, int hap) {
        if (hap > ans) return;
        if (cnt == N ) { //5가지를 구성했고 
            if(map[cur][1]!=0){ // 1로 돌아갈 수 있다면?
                res = hap + map[cur][1]; //마지막에 1로 돌아가기 
                ans = Math.min(ans, res); //최솟값인지 확인
            }
            return;
        }
        for (int i = 2; i <= N; i++) { //1에서 시작하는 중복없는 5가지 수열
            if (visited[i] || map[cur][i] == 0) continue; //방문했는지 그리고 갈 수 있는지 체크
            if (hap > ans) continue; // 이것보다 33번째 줄에서 return 해주는게 시간이 더 빠름
            visited[i] = true;
            recur(cnt+1, i ,hap+map[cur][i]); //5가지의 조합으로 가고? 
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        // ===================input===================
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(bf.readLine());
        map = new int[N+1][N+1]; //1부터 시작하므로
        visited = new boolean[14]; //숫자가 13까지 밖에 안되서
        ans = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

            }
        }
        // ===================sol===================
        recur(1,1,0); // 조합 구성 시작
        // ===================output===================
        System.out.println(ans);
    }
}
