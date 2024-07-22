import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        int n = 4;
        int r = 2;
        // 4개의 숫자 중 2개를 뽑는 조합
        List<int[]> result = combine(n, r);

        for (int[] comb : result) {
            for (int num : comb) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }


    public static List<int[]> combine(int n, int k) {
        // 결과를 저장할 리스트
        List<int[]> result = new ArrayList<>();
        // 임시 결과를 저장할 배열
        int[] tempArray = new int[k];
        // 백트래킹 실행
        //result: 결과를 저장할 리스트
        //tempArray: 임시 결과를 저장할 배열
        //n: 전체 숫자의 범위
        //k: 뽑을 숫자의 갯수
        //index: 임시 결과 배열의 인덱스
        //start: 숫자를 뽑기 시작할 위치
        backtrack(result, tempArray, n, k, 0, 1);
        return result;
    }

    private static void backtrack(List<int[]> result, int[] tempArray, int n, int k, int index, int start) {
        // 임시 결과 배열이 꽉 찼으면 결과 리스트에 추가
        if (index == k) {
            result.add(tempArray.clone());
            return;
        }

        // 임시 결과 배열에 숫자를 채워넣음
        for (int i = start; i <= n; i++) { // start부터 n까지의 숫자 중
            tempArray[index] = i; // 현재 인덱스에 해당 숫자를 넣어주고
            backtrack(result, tempArray, n, k, index + 1, i + 1); // 재귀적으로 다음 인덱스를 채워넣음
        }
    }
}