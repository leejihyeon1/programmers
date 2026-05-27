package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//정렬 - K번째 수
//배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때,
//k번째에 있는 수를 구하려 합니다.
//배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands
public class kthnumber {
    //1.문제를 단순하게 하기
    public int[] solution(int[] array, int[][] commands) {
        //2.배열 숫자 자르기
        int startIndex = 0; //시작인덱스
        int endIndex = 0;//끝인덱스
        int num = 0;//몇번째 숫자를 가져올건지l

        List<Integer> list = new ArrayList<>();
        int[] answer = new int[commands.length];

        for (int i=0; i< commands.length; i++){
            for(int j=0; j<commands.length; j++){
                startIndex = commands[j][0];
                endIndex = commands[j][1];
                num = commands[j][2];

                for(int q=startIndex-1; q<endIndex; q++){
                    list.add(array[q]);
                }

                //3.오름차순 정렬
                list.sort((a, b) -> a-b);

                //4.list -> array
                int[] arr = new int[list.size()];

                for(int w=0; w<list.size(); w++){
                    arr[w] = list.get(w);
                }
                //4.정렬된 배열 중 숫자 하나 선택
                answer[j] = arr[num-1];

                //리스트 초기화
                list.clear();
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        kthnumber k = new kthnumber();
        int[] array = new int[]{1, 5, 2, 6, 3, 7, 4};
        int[][] commands = new int[][]{{2, 5, 3},{4, 4, 1},{1, 7, 3}};
        k.solution(array,commands);
    }
}