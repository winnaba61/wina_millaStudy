import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2805_나무자르기 {
    private static int bs(int target, int[] trees){
        int left = 0;
        int right = trees[trees.length - 1];

        // 이진 탐색
        while (left <= right) {
            int mid = (left + right) / 2;
            long total = 0;
            // 잘린 나무의 길이 계산
            for (int tree : trees) {
                // 나무의 길이가 중간 값보다 클 때만 계산
                if (tree > mid) {
                    total += tree - mid;
                }
            }

            // 잘린 나무의 길이가 목표 값보다 크거나 같을 때
            if (total >= target) {
                left = mid + 1;
            }
            // 잘린 나무의 길이가 목표 값보다 작을 때
            else {
                right = mid - 1;
            }
        }
        // 최대 높이 반환
        return right;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] trees=new int[N];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            trees[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(trees); // 이진 탐색을 위한 정렬

        System.out.println(bs(M, trees));
    }
}
