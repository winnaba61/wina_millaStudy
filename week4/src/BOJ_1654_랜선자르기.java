import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1654_랜선자르기 {
    private static long lanLine(int target,int[] lines){
        //1. 내가 찾아야 할 정답의 범위를 left ~ right로 정한다.
        long left=1;
        long right=lines[lines.length-1];

        //4. left > right가 되면 반복을 끝내고 답을 반환한다.
        while(left<=right){
            long mid=(left+right)/2;
            long sum=0;

            //랜선의 길이를 mid로 나누어 몇 개의 랜선을 만들 수 있는지 계산
            for(int line:lines){
                sum+=line/mid;
            }

        //2. 정답을 mid로 간주한 후, 해당 정답이 유효한지 살펴본다.
        //3. 2번 여부를 따지며 left와 right의 범위를 좁힌다.
            //만들 수 있는 랜선의 개수가 목표보다 크거나 같을 때
            if (sum >= target) {
                left = mid + 1;
            }
            //만들 수 있는 랜선의 개수가 목표보다 작을 때
            else {
                right = mid - 1;
            }
        }
        return right;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken()); // 가지고 있는 랜선의 개수
        int N = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수
        int[] lines = new int[K];
        for(int i=0;i<K;i++){
            lines[i]=Integer.parseInt(br.readLine());
        }
        br.close();

        Arrays.sort(lines); // 이진 탐색을 위한 정렬

        //함수 호출 및 출력
        System.out.println(lanLine(N, lines));
    }
}
