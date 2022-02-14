import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Solution_6808_최강 {
    public static int T,M,cnt,N=9,ptr,w,l;
    public static boolean []gyuVisited;
    public static boolean []inVisited;
    public static int []arr;
    public static int []inNum;
    public static int []gyuNum;
    // =============================recur=============================
    public static void recur(int cur){
        if(cur == N){
            int inputRes=0, arrRes =0;
            for(int i=0; i<N;i++){ //규영이가 이기는경우
                if(gyuNum[i] > arr[i]){
                    inputRes += gyuNum[i]+arr[i];
                }else{
                    arrRes += gyuNum[i]+arr[i];
                }
            }
            if(inputRes>arrRes){ //완전히 이겼다면 w++
                w++;
            }else{
                l++;
            }
            return;
        }

        for(int i=0;i<9;i++){
            if(gyuVisited[i]) continue;
            arr[cur] = inNum[i]; //인영이의 숫자고르기
            gyuVisited[i] = true; //변수이름 왜 규영이가 됐...
            recur(cur+1);
            gyuVisited[i] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // =============================input=============================
        T = Integer.parseInt(bf.readLine());
        for(int test_case=0;test_case<T;test_case++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            arr = new int[2*N];
            gyuNum = new int[2*N];
            inNum = new int[2*N];
            gyuVisited = new boolean[2*N+1];
            inVisited = new boolean[2*N+1];
            ptr = 0;w=0;l=0;
            for(int i=0;i<N;i++){
                gyuNum[i] = Integer.parseInt(st.nextToken());
                inVisited[gyuNum[i]] = true;
            }
            // =============================sol=============================
            for(int i =1;i<= 2*N;i++){
                if(!inVisited[i]){ //규영이가 고르지 않은 숫자만 넣기
                    inNum[ptr++] = i;
                }
            }
            recur(0);

            // =============================output=============================
            sb.append('#').append(test_case+1).append(' ').append(w).append(' ').append(l).append('\n');
        }
        System.out.println(sb);
    }
}
