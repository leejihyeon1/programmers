package Sort;

import java.util.Arrays;
import java.util.Comparator;

//정렬 - H-INDEX
//hIndex = h번 이상 인용된 논문의 개수는 h이상이어야함!
public class hIndex {
    public int solution(int[] citations) {
        Integer[] c = new Integer[citations.length];
        int num=0;
        for(int i:citations){
            c[num++] = Integer.valueOf(i);
        }
        Arrays.sort(c, Comparator.reverseOrder());

        int answer = 0;//인용된 논문 개수
        int hIndex = 0; //인용된 논문 수 최댓값
        for(int j=c[0]; j>=0; j--){
            hIndex = j;
            for(int i=0; i<c.length; i++){
                if(hIndex <= c[i]) answer++;
            }
            if(answer >= hIndex) {
                break;
            }else{
                answer = 0;
            }

        }
        return hIndex;
    }
}