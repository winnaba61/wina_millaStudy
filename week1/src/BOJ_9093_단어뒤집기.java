import java.util.Scanner;

public class BOJ_9093_단어뒤집기 {
    static String reverse(String[] str){
        String result="";
        for(int i=0;i<str.length;i++){
            for(int j=str[i].length()-1;j>=0;j--){
                result+=str[i].charAt(j);
            }
            result+=" ";
        }
        return result.trim();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for(int t=0;t<T;t++){
            String str=sc.nextLine();
            String[] words=str.split(" ");

            System.out.println(reverse(words));
        }
        sc.close();
    }
}
