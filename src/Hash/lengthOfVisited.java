package Hash;

import java.util.HashSet;
import java.util.Set;

//summer/winter coding - 방문 길이
public class lengthOfVisited {
    public int solution(String dirs) {
        int answer = 0;
        //평면 그리기
        //지나간 곳은 -1, 기본값은 0
        //이미 -1이면 카운트 안함
        Set<String> visited = new HashSet<>();

        //현재 캐릭터 좌표
        int row = 0, column = 0;


        //이동 좌표 표본
        int[] dRow = {1, -1, 0, 0};
        int[] dCol = {0, 0, -1, 1};
        String dirChars = "UDLR";

        for(int i=0; i<dirs.length(); i++){
            char c = dirs.charAt(i);
            int dir = dirChars.indexOf(c);

            int nRow = row+dRow[dir];
            int nColumn = column+dCol[dir];


            // 범위를 벗어나면 이동 자체를 무시
            if(nRow < -5 || nRow > 5 || nColumn < -5 || nColumn > 5){
                continue;  // 이동 안 하고 다음 명령으로
            }

            //출발지점 - 도착지점, 도착지점 - 출발지점은 같은걸로 봐야하기때문에
            //왕복 2개의 경우 생성
            String edge1 = row + "," + column + "-" + nRow + "," + nColumn;
            String edge2 = nRow + "," + nColumn + "-" + row + "," + column;

            if (!visited.contains(edge1) && !visited.contains(edge2)) {
                visited.add(edge1);
                answer++;
            }
            row = nRow;
            column = nColumn;

        }


        return answer;
    }
}