package Stack_Queue;

import java.util.Stack;

//2019 카카오 개발자 겨울 인턴십 - 크레인 인형뽑기 게임
public class crane {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();
        //moves는 열 번호
        for(int i=0; i<moves.length; i++){
            int move = moves[i]-1;
            for(int j=0; j<board.length; j++){
                if(board[j][move] == 0){
                    continue;
                }
                if(!basket.isEmpty()){
                    if(basket.peek() == board[j][move]){//바구니에 인형이 2개가 같을때
                        basket.pop();
                        answer += 2;//인형 2개가 터지니까
                    }else{//인형이 다를때
                        basket.push(board[j][move]);
                    }
                }else{
                    basket.push(board[j][move]);
                }
                board[j][move] = 0;
                break;
            }
        }
        return answer;
    }
}