import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1182_부분수열의합 {
    static int N, S;
    static int[] arr;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        // 입력 받은 수를 배열에 저장
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 부분수열의 합을 구하는 함수 호출
        bt(0, 0);

        // S가 0인 경우 공집합 제외
        if (S == 0) cnt--;

        System.out.println(cnt);

        // 입력 버퍼 종료
        br.close();
    }

    // 부분수열의 합을 구하는 함수
    public static void bt(int depth, int sum) {
        // 모든 원소를 확인했을 때
        if (depth == N) {
            // 부분수열의 합이 S와 같다면 cnt 증가
            if (sum == S) {
                cnt++;
            }
            return;
        }

        // 현재 원소를 포함하지 않는 경우
        bt(depth + 1, sum);

        // 현재 원소를 포함하는 경우
        bt(depth + 1, sum + arr[depth]);
    }
}
