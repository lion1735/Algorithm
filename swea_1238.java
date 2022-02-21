import java.io.*;
import java.util.*;
public class Main {
    static int n,m,v,depth,ptr,maxNum;
    static int [][] res;
    static int [][] map;
    static boolean []visited;
    static StringBuilder sb;
    //==============================bfs==============================
    static void bfs(int node){
        Queue <int[]>que = new LinkedList<>();
        que.offer(new int[]{node,0}); //처음 데이터를 큐에 넣음
        depth = ptr = 0; //depth
        visited[node] = true; //방문 처리
        while(!que.isEmpty()){ //큐가 비어있을때까지
            int[] temp = que.poll(); //큐에서 데이터를 뽑기
            depth = Math.max(depth,temp[1]);
            for(int i=1;i<n+1;i++){ //배열 끝까지 탐색
                if(!visited[i] && map[temp[0]][i] == 1){ //방문하지 않은 노드 그리고 연결되어 있는 노드 탐색
                    que.offer(new int[]{i,temp[1]+1});//큐에 넣기
                    visited[i] =true;//방문 처리
                    res[ptr][0] = i; //방문한 노드 배열에 저장
                    res[ptr++][1] = temp[1]+1; //방문한 노드의 깊이 저장
                }
            }
        }
        for(int i=0;i< ptr; i++){ //ptr에 탐색한 갯수를 담아 반복
            if(res[i][1]==depth){ //최대 깊이와 같다면
                maxNum = Math.max(maxNum,res[i][0]); //maxNum에 가장 큰 값 저장
            }
        }
    }
    public static void main(String[] args) throws IOException{
        //==============================input==============================
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        sb = new StringBuilder();
        for(int testCase = 1;testCase <= T;testCase++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            n = 100;//노드갯수 
            m = Integer.parseInt(st.nextToken()); //간선갯수
            v = Integer.parseInt(st.nextToken()); //탐색시작번호
            maxNum =0; //결과 저장 변수
            map = new int[n+1][n+1];
            res = new int[n+1][2]; //큐에 탐색했던 노드 정보를 담을 변수
            visited = new boolean[n+1];
            st = new StringTokenizer(bf.readLine());
            for(int i=0;i<m/2;i++){
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                map[from][to] = 1; //노드 저장
            }
            //==============================sol==============================
            bfs(v); //bfs(v) 부터 탐색시작
            sb.append('#').append(testCase).append(' ').append(maxNum).append('\n');
        }
        //==============================output==============================
        System.out.println(sb);
    }
}
