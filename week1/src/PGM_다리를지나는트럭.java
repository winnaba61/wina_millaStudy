import java.util.*;
import java.lang.*;

public class PGM_다리를지나는트럭 {
    static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> bridge = new LinkedList<>(); //다리 위 트럭
        Queue<Integer> truck= new LinkedList<>(); //대기중인 트럭
        for(int i :truck_weights){ //배열을 ArrayList로 변환
            truck.add(i);
        }
        int bridge_weight = 0;

        while(truck.size()>0){
            answer++;
            int tmp = truck.peek();
            if(tmp+bridge_weight<=weight){
                truck.poll();
                bridge.add(tmp);
                bridge_weight+=tmp;
            }
            else{
                bridge.poll();
            }
            System.out.println("대기중인 트럭"+truck);
            System.out.println("다리를 지나는 트럭"+bridge);
        }

        return answer;
    }

    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};

        System.out.println(solution(bridge_length, weight, truck_weights));
    }
}
