import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_10828_스택 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>(); // 스택 생성

        for(int i=0;i<N;i++){ //N번의 명령 반복
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd =st.nextToken();
            if(cmd.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                stack.push(num);
            }
            else if(cmd.equals("pop")){
                if(stack.isEmpty()){ //스택에 들어있는 정수가 없는 경우
                    bw.write("-1\n");
                }
                else{
                   bw.write(stack.pop()+"\n"); //가장 위에 있는 정수를 빼고, 그 수를 출력
                }
            }
            else if(cmd.equals("size")){
                bw.write(stack.size()+"\n"); //스택에 들어있는 정수의 개수를 출력
            }
            else if(cmd.equals("empty")){
                if(stack.isEmpty()){ //스택이 비어있는지 확인
                    bw.write("1\n");
                }
                else{
                    bw.write("0\n");
                }
            }
            else if(cmd.equals("top")){
                if(stack.isEmpty()){
                   bw.write("-1\n");
                }
                else{
                    bw.write(stack.peek()+"\n"); //가장 위에 있는 정수를 출력
                }
            }
        }
        br.close(); //스트림 닫기
        bw.flush(); //남아있는 데이터를 모두 출력
        bw.close(); //스트림 닫기
    }
}
