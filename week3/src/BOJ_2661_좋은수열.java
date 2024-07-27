import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2661_좋은수열 {
    static int N;
    static int[] arr={1,2,3};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 입력 받기
        N = Integer.parseInt(st.nextToken());
        br.close();

        //백트래킹 함수호출
        bt("");
    }

    //백트래킹 함수
    private static void bt(String sequence){
        //종료조건
        if(sequence.length()==N){
            System.out.println(sequence);
            System.exit(0);
        }

        //탐색
        for(int i=0;i<3;i++){
            //좋은 수열인지 확인
            if(check(sequence+arr[i])){
                bt(sequence+arr[i]);
            }
        }
    }


    //좋은 수열인지 확인하는 함수
    private static boolean check(String sequence){
        int length=sequence.length();
        for(int i=1;i<=length/2;i++){
            //길이가 i인 두 개의 수열이 같은지 확인
            if(sequence.substring(length-i).equals(sequence.substring(length-2*i,length-i))){
                return false;
            }
        }
        return true;
    }

}
