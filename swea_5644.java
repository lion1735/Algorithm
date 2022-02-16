import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static int[][][] map;
    public static int []dx ={0,0,1,0,-1};
    public static int []dy ={0,-1,0,1,0};
    public static int []A;
    public static int []B;
    public static int []ptrA;
    public static int []ptrB;
    public static int n,m,res;
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(bf.readLine());
        for(int testCase = 1; testCase<=T; testCase++){
            // ===================input===================
            map = new int[11][11][3]; //map배열 생성 [2] = 어차피 최대 2명만 서있기 때문에 [0]에 저장하고 하나 더 겹치면 [1]에 저장하기
            st = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken()); //2쌍의 이동정보,n개의 이동정보
            m = Integer.parseInt(st.nextToken()); //m개의 AP정보
            A = new int[n];
            B = new int[n];
            st = new StringTokenizer(bf.readLine());
            for(int i=0;i<n;i++){ //A의 이동정보 
                A[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(bf.readLine());
            for(int i=0;i<n;i++){ //B의 이동정보
                B[i] = Integer.parseInt(st.nextToken());
            }
            for(int i=0;i<m;i++){ //AP의 좌표
                st = new StringTokenizer(bf.readLine());
                int px = Integer.parseInt(st.nextToken());
                int py = Integer.parseInt(st.nextToken());
                int range = Integer.parseInt(st.nextToken());
                int performance = Integer.parseInt(st.nextToken());
                for(int y=py-range;y<=py+range;y++){
                    for(int x=px-range;x<=px+range;x++){
                        int d = (int)Math.abs(x-px) + (int)Math.abs(y-py); //거리 계산
                        if(d>range || x < 1 || x >= 11 || y<1 || y>=11)continue; //범위 체크
                        if (map[y][x][2] == 0) map[y][x][2]=i; //몇 번째로 들어온 차져인지 체크
                        if(map[y][x][0] == 0){ //첫 차져라면
                            map[y][x][0] = performance;
                        }else if(map[y][x][0] < performance && map[y][x][1] == 0){ //새로 들어온 차져가 첫 차져보다 크다면?
                            map[y][x][1] = map[y][x][0];
                            map[y][x][0] = performance;
                        }else if(map[y][x][1] == 0){ //크지 않다면 두 번째 차져에 저장
                            map[y][x][1] = performance;
                        }else if(map[y][x][0] < performance){ //모두 차지되어있을때 값이 더 크다면
                            map[y][x][0] = performance;
                        }else if(map[y][x][1] < performance){
                            map[y][x][1] = performance;
                        }
                    }
                }
            }
            for(int y=1;y<11;y++){
                for(int x=1;x<11;x++){
                    System.out.printf("{%5d,%5d} ",map[y][x][0],map[y][x][1]);
                }System.out.println();
            }
        
            // ===================sol===================
            ptrA = new int[]{1,1};
            ptrB = new int[]{10,10};
            int chargeA = 0; //A의 차징 게이지
            int chargeB = 0; //B의 차징 게이지
            res = map[ptrA[0]][ptrA[1]][0] + map[ptrB[0]][ptrB[1]][0];
            for(int i=0;i<n;i++){
                int nyA = ptrA[0] + dy[A[i]];
                int nxA = ptrA[1] + dx[A[i]];
                int nyB = ptrB[0] + dy[B[i]];
                int nxB = ptrB[1] + dx[B[i]];
                System.out.printf("A[%d,%d] = %d  %d번째 차져임\n",nyA,nxA,map[nyA][nxA][0],map[nyA][nxA][2]);
                // System.out.printf("B[%d,%d] = %d\n",nyB,nxB,map[nyB][nxB][0]);
                //범위 밖으로 벗어나는 경우가 없음. 체크X
                chargeA = map[nyA][nxA][0];
                chargeB = map[nyB][nxB][0];
                if(chargeA == chargeB && map[nyA][nxA][2] == map[nyB][nxB][2]){ //두 값이 같다면? 같은 차져를 쓰는중임
                    System.out.println(nyA+","+nxA);
                    if(map[nyA][nxA][1] != 0 ){ //B의 차져를 바꿀 수 있다면
                        chargeA = map[nyA][nxA][1];
                    }else if(map[nyB][nxB][1] != 0){//A의 차져를 바꿀 수 있다면
                        chargeB = map[nyB][nxB][1];
                    }else{//차져가 하나뿐인 경우
                        chargeA /= 2;
                        chargeB /= 2;
                    }
                }
                res += (chargeA + chargeB);
                ptrA[0] =nyA;
                ptrA[1] =nxA;
                ptrB[0] =nyB;
                ptrB[1] =nxB;
            }
            sb.append('#').append(testCase).append(' ').append(res).append('\n');
        }
        // ===================output===================
        System.out.println(sb);
    }
}
