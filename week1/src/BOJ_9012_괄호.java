import java.util.Scanner;
import java.util.Stack;

public class BOJ_9012_괄호 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int t=0;t<T;t++){
            String ps=sc.next();
            Stack<Character> stack=new Stack<>();

            for(int i=0;i<ps.length();i++){
                char c=ps.charAt(i);
                if(c=='('){ //여는 괄호면 스택에 넣기
                    stack.push(c);
                }else{//닫는 괄호면 스택에서 빼기
                    if(stack.isEmpty()){ //스택이 비어있으면 NO
                        stack.push(c); //isEmpty를 사용할 때 오류가 발생하지 않기 위함
                        break;
                    }else{
                        stack.pop(); //스택에서 여는 괄호 빼기
                    }
                }
            }
            if(stack.isEmpty()) {
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }

        }
        sc.close();
    }
}
