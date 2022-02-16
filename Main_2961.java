import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main_2961_최강 {
    public static int N,min=1000000000;
    public static int M;
    public static int [][] material;
    // ===================recur===================
    public static void recur(int inputCnt,int cur,int gop, int hap){
        if(inputCnt!=0){
            min = Math.min(min,Math.abs(hap-gop));
        }
        if(cur==N) return;
        recur(inputCnt+1,cur+1,gop*material[cur][0],hap+material[cur][1]); //재료 넣기
        recur(inputCnt,cur+1,gop,hap); //재료 빼기
    }
    public static void main(String[] args) throws IOException {
        // ===================input===================
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(bf.readLine());
        material = new int[N][2];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(bf.readLine());
            material[i][0] = Integer.parseInt(st.nextToken());
            material[i][1] = Integer.parseInt(st.nextToken());
        }
        // ===================sol===================
        recur(0,0,1,0);
        // ===================output===================
        System.out.println(min);
    }
}
