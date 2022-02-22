import java.io.*;
import java.util.*;
public class Main {
    static int n,m,res;
    static int [][] map;
    static boolean [] visited;
    static StringBuilder sb;
    //==============================dfs==============================
    public static void dfs(int y, int x){
        if(y<1 || x<1  || x>n || y>n || map[y][x]==0) return; //범위체크
        map[y][x] = map[x][y] = 0; //방문처리
        for(int i=1;i<=n;i++){
            dfs(y,i); //가로탐색
            dfs(i,x); //세로탐색
        }
    }
    public static void main(String[] args) throws IOException{
        //==============================input==============================
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        sb = new StringBuilder();
        for(int testCase = 1;testCase <= T;testCase++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken()); //최대 수
            m = Integer.parseInt(st.nextToken()); //링크 갯수
            map = new int[n+1][n+1];
            visited = new boolean[n+1]; //방문한 숫자 체크
            res = 0;
            for(int i=0;i<m;i++){
                st = new StringTokenizer(bf.readLine());
                if(st.countTokens() == 2){ //입력받은 수가 2개라면 map에 할당
                    int y = Integer.parseInt(st.nextToken());
                    int x = Integer.parseInt(st.nextToken());
                    map[y][x] = map[x][y] = 1;
                    visited[y] = visited[x] = true;
                }else{ //입력받은 수가 1개라면 연결된 값이 없으므로 자기자신을 참조하도록
                    //근데 그냥 temp = 1안하고 res++로만 해도 통과가능, 테케가 부실한듯
                    //다른수가 나를 참조하면 같은 그룹아닌가..?왜 통과되는지 몰루
                    int temp = Integer.parseInt(st.nextToken());
                    map[temp][temp] = 1;
                    visited[temp] = true;
                }
            }
            //==============================sol==============================
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(map[i][j]==1 || map[j][i]==1){ // 연결된 노드들 탐색하기
                        dfs(i,j);
                        res++;
                    }
                }
            }
            for(int i=1;i<=n;i++){
                if(!visited[i]) res++; //탐색되지 않은 수들도 하나의 그룹이므로 res++
            }
            sb.append('#').append(testCase).append(' ').append(res).append('\n');
        }
        //==============================output==============================
        System.out.println(sb);
    }
}
