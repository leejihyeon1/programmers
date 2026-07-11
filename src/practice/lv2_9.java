package practice;

//완전탐색 - 카펫
public class lv2_9 {
    public int[] solution(int brown, int yellow) {
        //전체 = width * height
        //yellow = (width-2) * (height-2) -> 노란색의 가로세로의 양 끝 2개는 반드시 갈색이기 때문에-2
        //brown = 전체(width*height) - yellow((width-2) * (height-2))
        int[] answer = new int[2];

        //1. yellow의 약수 찾기
        for(int i=1; i*i <= yellow; i++){
            if(yellow % i == 0){
                int innerHeight = i;
                int innerWidth = yellow / i;

                //전체 가로,세로(갈색 타일 2개 추가)
                int width = innerWidth + 2;
                int height = innerHeight + 2;

                //2. 각 약수 쌍마다 가로 세로 대입해보고 brown이 맞는지 확인
                if(brown == (width*height) - yellow){
                    answer[0] = width;
                    answer[1] = height;
                }
            }
        }

        return answer;
    }
}