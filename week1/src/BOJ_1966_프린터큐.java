import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1966_프린터큐 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int t=0;t<T;t++) {
            Queue<Integer> printer = new LinkedList<>();
            int N = sc.nextInt();
            int M = sc.nextInt(); //궁금한 문서의 위치

            for (int n = 0; n < N; n++) {//중요도 입력
                printer.add(sc.nextInt());
            }

            int cnt=0;
            int idx=M; //궁금한 문서의 위치

            while(!printer.isEmpty()){
                int tmp=printer.poll(); //첫번째 원소를 빼서 tmp에 저장
                boolean flag=true;

                for(int i:printer){ //tmp보다 큰 수가 있으면 flag를 false로 바꿈
                   if(tmp<i){
                       flag=false;
                       break;
                   }
                }

                if(flag){
                    cnt++;
                    if(idx==0){//궁금한 문서가 출력되었으면 종료
                        break;
                    }
                }
                else{ //tmp보다 큰 수가 있으면 다시 큐에 넣음
                    printer.add(tmp);
                }

                if(idx==0){ //궁금한 문서의 순서인데, 중요도가 제일 높지 않음
                    idx=printer.size()-1;
                }
                else{ //궁금한 문서의 순서가 아님
                    idx--;
                }
            }
            System.out.println(cnt);
        }
        sc.close();
    }
}
