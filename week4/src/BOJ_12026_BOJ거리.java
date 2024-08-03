import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12026_BOJ거리 {
    private static int dp(int N,char[] blocks){
        int[] arr =new int[N];
        arr[0]=0;
        for(int i=1;i<N;i++){
            arr[i]=Integer.MAX_VALUE; //최솟값을 구하기 위해 최댓값으로 초기화
        }

        for(int i=0;i<N;i++){ //i번째 블록까지의 최소 비용
            for(int j=i+1;j<N;j++){ //j번째 블록까지의 최소 비용
                //j번째 블록이 i번째 블록의 다음 블록일 때
                if(blocks[j]==nextBlock(blocks[i])){
                    if(arr[i]!=Integer.MAX_VALUE){
                        arr[j]=Math.min(arr[j],arr[i]+(j-i)*(j-i)); //비용 계산
                    }
                }
            }
        }

        //N번째 블록까지의 최소 비용
        int ans=arr[N-1];
        if(ans==Integer.MAX_VALUE){
            return -1;
        }
        else{
            return ans;
        }
    }

    private static char nextBlock(char block){
        //B->O->J->B
        if(block=='B'){
            return 'O';
        }else if(block=='O'){
            return 'J';
        }else{
            return 'B';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //입력 받기
        int N = Integer.parseInt(st.nextToken());
        char[] blocks=br.readLine().toCharArray();

        System.out.println(dp(N,blocks));

        br.close();
    }
}