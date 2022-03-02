import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    static int N, M, cctvCnt,res,hap;
    static ArrayList <int []> arrCCTV;
    static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } }; // 캠 방향 우좌상하
    static int[][][] dirMap = { // 캠이 볼 수 있는 경우의 수
            { { 0 } },
            { { 1 }, { 2 }, { 3 }, { 0 } }, // 우 좌 상 하 
            { { 0, 1 }, { 2, 3 } }, // 우좌, 상하
            { { 0, 2 }, { 0, 3 }, { 1, 3 }, { 1, 2 } }, // 우상, 우하, 좌하, 좌상
            { { 0, 1, 2 }, { 0, 2, 3 }, { 0, 1, 3 }, { 1, 2, 3 } }, // 하, 좌, 상, 우 빼고
            { { 0, 1, 2, 3 } } // 모든 곳 탐색
    };
    static int[][] map;

    static void recur(int cur, int cnt, int [][]map) {
        // System.out.println("cc:"+cctvCnt);
        if(cur == cctvCnt){
            res = Math.min(res,cnt);
            return;
        }
        int [][] newMap = new int[N][M];
        MapCopy(map, newMap); //기존 맵의 정보를 새로운 객체 맵에 복사(깊은 복사)
        int [] temp = arrCCTV.get(cur); //CCTV정보(y,x,map[y][x])
        for(int i=0;i<dirMap[temp[2]].length;i++){ //dirMap에서 해당하는 CCTV만큼 반복
            int ptr =0;
            for(int j=0;j<dirMap[temp[2]][i].length;j++){ //해당하는 CCTV가 가지는 방향만큼 반복
                int  d = dirMap[temp[2]][i][j]; //1개의 방향 값
                ptr += Check(temp[0],temp[1],d,newMap); //갯수 세기
            }
            recur(cur+1, cnt-ptr, newMap); //다른 방향 체크
            MapCopy(map, newMap); // 다시 탐색해야하므로 깊은복사
        }
    }
    static int Check(int y,int x, int d, int[][]map){
        int hap =0;
        int ny=y,nx=x;
        while(true){
            // System.out.println("-------------------------------------------");
            // for(int i=0;i<N;i++){
            //     for(int j=0;j<M;j++){
            //         System.out.printf("%d ",map[i][j]);
            //     }System.out.println();
            // }
            ny += dir[d][0];
            nx += dir[d][1];
            if(ny < 0 || nx< 0 || ny >=N || nx>=M ||map[ny][nx] ==6) return hap; //범위가 끝났거나 벽을 만났을때
            if(map[ny][nx] >= 1 && map[ny][nx] <=5 || map[ny][nx] == -1) continue; //이미 다른 CCTV가 탐색했거나 CCTV라면 패스
            map[ny][nx] = -1;
            hap++;
        }
    }
    static void MapCopy(int[][] map, int[][] newMap) { //깊은 복사
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newMap[i][j] = map[i][j];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // ===================input===================
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        arrCCTV = new ArrayList<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cctvCnt = 0;
        res = N*M;
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 6) {  //벽이라면 -1
                    res--;
                }else if(map[i][j] != 0){ //CCTV 찾아서 저장
                    cctvCnt++;         
                    arrCCTV.add(new int[]{i,j,map[i][j]}); //List에 CCTV 좌표와 값 저장하기
                }
            }
        }
        // ===================sol===================
        recur(0,res - cctvCnt,map);
        // ===================output===================
        System.out.println(res);
    }
}
