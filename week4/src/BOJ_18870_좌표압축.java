import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_18870_좌표압축 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        br.close();

        int[] result=bs(arr);
        StringBuilder sb = new StringBuilder();
        for(int num:result){
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }

    private static int[] bs(int[] arr){
        int[] result=new int[arr.length];
        // 중복 제거를 위한 정렬
        int[] sortedArr=arr.clone();
        Arrays.sort(sortedArr);

        Map<Integer, Integer> map = new HashMap<>();
        int rank=0;
        // 중복 제거
        for(int num:sortedArr){
            if(!map.containsKey(num)){
                map.put(num, rank++);
            }
        }

        // 결과 배열에 값 대입
        for(int i=0;i<arr.length;i++){
            result[i]=map.get(arr[i]);
        }

        return result;
    }
}
