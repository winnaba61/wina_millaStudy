import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12026_BOJ거리 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int[] blocks=new int[N];
        for(int i=0;i<N;i++){
            blocks[i]=Integer.parseInt(st.nextToken());
        }
        br.close();


    }
}
