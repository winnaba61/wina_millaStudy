import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_1158_요세푸스 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.close();

        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0;i<N;i++){
            list.add(i+1);
        }

        ArrayList<Integer> result = new ArrayList<>();
        int idx=0; //제거할 사람의 인덱스
        while(!list.isEmpty()){//리스트가 비어있지 않을 때까지 반복
            idx= (idx+K-1)%list.size(); //%연산자를 사용하여 인덱스 범위를 벗어나지 않도록 함
            result.add(list.remove(idx));
        }

        System.out.print("<");
        for(int i=0;i<N;i++){
            System.out.print(result.get(i));
            if(i!=N-1){ //마지막 수는 콤마 출력하지 않음
                System.out.print(", ");
            }
        }
        System.out.println(">");
    }
}
