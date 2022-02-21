import java.io.*;
import java.util.*;
public class Main {
    static int n,m,v;
    static int [][] map;
    static boolean []visited;
    static StringBuilder sb;
    //==============================dfs==============================
    static void dfs(int start){ 
        sb.append(start).append(' '); //sb에 저장
        visited[start] = true; //dfs에서는 탐색하면 true로 변환하고 bfs에서 true인것만 찾기
        for(int i=1;i<n+1;i++){
            if(!visited[i] && map[start][i] == 1){ //방문하지 않은 노드 그리고 연결되어있는 노드 탐색
                dfs(i);
            }
        }
    }
    //==============================bfs==============================
    static void bfs(int node){
        Queue <Integer>que = new LinkedList<>();
        que.offer(node); //처음 데이터를 큐에 넣음
        visited[node] = false; //dfs에서 true처리 되있던 걸 false로 변환
        while(!que.isEmpty()){ //큐가 비어있을때까지
            int temp = que.poll(); //큐에서 데이터를 뽑기
            sb.append(temp).append(' '); //sb에 저장
            for(int i=1;i<n+1;i++){ //배열 끝까지 탐색
                if(visited[i] && map[temp][i] == 1){ //dfs에서 방문했던 노드 그리고 연결되어 있는 노드 탐색
                    que.offer(i);//큐에 넣기
                    visited[i] =false;//true -> false로 변환
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        //==============================input==============================
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken()); //노드갯수
        m = Integer.parseInt(st.nextToken()); //간선갯수
        v = Integer.parseInt(st.nextToken()); //탐색시작번호
        map = new int[n+1][n+1];
        visited = new boolean[n+1];
        sb = new StringBuilder();
        for(int i=0;i<m;i++){
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = map [y][x] = 1; //노드 저장
        }
        //==============================sol==============================
        dfs(v); //dfs(v) 부터 탐색시작
        sb.append('\n'); //결과 한줄 개행
        bfs(v); //bfs(v) 부터 탐색시작
        //==============================output==============================
        System.out.println(sb);
    }
}
