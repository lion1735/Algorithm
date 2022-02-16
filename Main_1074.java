import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static int n,r,c,res=-1,ptr=0;
    public static void recur(int x,int y, int N){
        if(x>r || r >= x+N || y>c || c >= y+N){
            res += N*N;
            return;
        }

        if(N==2){
            ptr = 0;
            for(int i=x;i<x+N;i++){
                for(int j=y;j<y+N;j++){
                    ptr ++;
                    if(i==r && j==c){
                        System.out.println(res+ptr);
                        System.exit(0);
                    }
                }
            }
            return;
        }
        int p = N/2;
        for(int i=x;i<x+N;i+=p){
            for(int j=y;j<y+N;j+=p){
                    recur(i,j,p);
                }
            }
        }
    public static void main(String[] args) throws IOException {
        // ===================input===================
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        // ===================sol===================
        recur(0,0,(int)Math.pow(2, n));
        // ===================output===================
    }
}
