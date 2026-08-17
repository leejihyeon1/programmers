package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//정렬 - K번째 수
//배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때,
//k번째에 있는 수를 구하려 합니다.
//배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands
public class kthNumber_v2 {
    //1.문제를 단순하게 하기
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0; i<commands.length; i++){
            //Arrays.copyOfRange(배열,시작인덱스,끝인덱스+1) -> 시작은 포함하지만 끝 인덱스는 포함하지않기때문
            int[] arr = Arrays.copyOfRange(array,commands[i][0]-1,commands[i][1]);
            Arrays.sort(arr);
            answer[i] = arr[commands[i][2]-1];
        }
        return answer;
    }
}