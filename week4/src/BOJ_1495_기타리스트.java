import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1495_기타리스트 {
    static int N,S,M;
    static int[] V;

    private static int dp(){
        boolean[][] possible=new boolean[N+1][M+1];
        possible[0][S]=true;

        //i번째 곡을 연주할 때 볼륨 j가 가능한지 여부
        for(int i=1;i<N+1;i++){
            for(int j=0;j<M+1;j++){
                if(possible[i-1][j]){
                    if(j-V[i]>=0){
                        possible[i][j-V[i]]=true;
                    }
                    if(j+V[i]<=M){
                        possible[i][j+V[i]]=true;
                    }
                }
            }
        }

        int max=-1;
        //마지막 곡을 연주할 때 가능한 볼륨 중 최댓값
        for(int i=0;i<M+1;i++){
            if(possible[N][i]){
                max=i;
            }
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken()); //공연에서 연주할 곡의 수
        S=Integer.parseInt(st.nextToken());//시작 볼륨
        M=Integer.parseInt(st.nextToken());//볼륨의 최댓값

        //각 곡이 시작하기 전에 줄 수 있는 볼륨의 차이
        V=new int[N+1];
        st=new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            V[i]=Integer.parseInt(st.nextToken());
        }

        br.close();

        System.out.println(dp());
    }
}