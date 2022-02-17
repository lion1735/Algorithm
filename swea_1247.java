import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.zip.CheckedInputStream;
import java.io.IOException;

public class Solution {
    static int N, res;
    static int[] home,company,customer;
    static int[][] map;
    static boolean []visited;
    

    // ===================recur===================
    static void recur(int cur) {
        if(cur == N){ // 탐색이 종료되었다면 
            int hap =0,cus,cusNum;
            for(int i=0;i<N-1;i++){  //해당 고객과 다음 고객 좌표 계산
                cus = customer[i];
                cusNum = customer[i+1];
                hap += Math.abs(map[cus][0] - map[cusNum][0]) + Math.abs(map[cus][1] - map[cusNum][1]);
            }
            hap += Math.abs(company[0] - map[customer[0]][0]) + Math.abs(company[1] - map[customer[0]][1]);
			hap += Math.abs(home[0] - map[customer[N - 1]][0]) + Math.abs(home[1] - map[customer[N - 1]][1]);
			res = Math.min(hap, res);
        }
        for(int i=0;i<N;i++){
            if(visited[i]) continue;
            visited[i] = true;
            customer[cur] = i;
            recur(cur+1);
            visited[i] = false;
        }
        return ;
	}

    public static void main(String[] args) throws IOException {
        // ===================input===================
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(bf.readLine());
        for(int testCase = 1; testCase<=T; testCase++){
            N = Integer.parseInt(bf.readLine());
            customer = new int[N]; //결과들을 담을 배열
            visited = new boolean[N]; //방문했는지 체크
            map = new int[N][2]; //좌표 맵
            res = 1000001;
            StringTokenizer st = new StringTokenizer(bf.readLine());
            company = new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
            home = new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
            for (int i = 0; i < N; i++) {
                map[i][0] = Integer.parseInt(st.nextToken());
                map[i][1] = Integer.parseInt(st.nextToken());
            }
            // ===================sol===================
            recur(0);
            sb.append('#').append(testCase).append(' ').append(res).append('\n');
        }
        // ===================output===================
        System.out.println(sb);
    }
}
