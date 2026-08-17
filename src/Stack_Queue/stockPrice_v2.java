package Stack_Queue;

//스택/큐 - 주식가격
public class stockPrice_v2 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i=0; i<prices.length; i++){
            int price = prices[i];
            int cnt = 0;
            for(int j=i+1; j<prices.length; j++){
                cnt++;
                if(price > prices[j]){
                    break;
                }
            }
            answer[i] = cnt;
        }
        return answer;
    }
}