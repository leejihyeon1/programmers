package FullSearch;

//완전탐색 - 카펫
public class carpet_v2 {
    public int[] solution(int brown, int yellow) {
        //약수 구하기
        int sum = brown+yellow;
        int[] answer = new int[2];

        for(int i=1; i*i<=sum; i++){
            //Math.sqrt() : 제곱근 구하기
            if(sum % i == 0){
                int w = sum / i;//가로(더 큰 값)
                int h = i;//세로(더 작은 값)

                if((w-2)*(h-2) == yellow){
                    answer[0] = w;
                    answer[1] = h;
                }
            }
        }
        return answer;
    }
}