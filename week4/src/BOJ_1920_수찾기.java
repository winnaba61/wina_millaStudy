import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920_수찾기 {
    private static int binarySearch(int target, int[] arr){
        int left=0; //왼쪽 끝
        int right=arr.length-1; //오른쪽 끝

        while(left<=right){
            int mid=(left+right)/2;

            //찾는 값이 중간 값과 같을 때
            if(arr[mid]==target){
                return 1;
            }else if(arr[mid]>target){ //찾는 값이 중간 값보다 작을 때
                right=mid-1;
            }else{ //찾는 값이 중간 값보다 클 때
                left=mid+1;
            }
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //N부분 입력
        int N = Integer.parseInt(br.readLine());
        int[] arrN = new int[N];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int n = 0; n < N; n++){
            arrN[n] = Integer.parseInt(st.nextToken());
        }
        //이진 탐색을 위한 정렬
        Arrays.sort(arrN);

        //M부분 입력
        int M = Integer.parseInt(br.readLine());
        int[] arrM = new int[M];
        st=new StringTokenizer(br.readLine());
        for(int m = 0; m < M; m++){
            arrM[m] = Integer.parseInt(st.nextToken());
        }
        br.close();

        for(int m:arrM){
            System.out.println(binarySearch(m, arrN));
        }
    }
}
