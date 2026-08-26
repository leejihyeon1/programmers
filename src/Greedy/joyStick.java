package Greedy;

//그리디 - 조이스틱
public class joyStick {
    public int solution(String name) {
        int answer = 0;
        //알파벳 아스키/유니코드 값이 있어서 알파벳 배열 하드코딩 안해도 됨
        //'J'-'A' = 9 나옴

        //정방향과 역방향 중 어떤게 더 최소값인지 구분 필요
        //모든 문자의 시작은 name글자수에 맞게 AAA..로 시작
        //A에서 원하는 문자로 이동하는 수 + 글자수(i) 이동 커서 수
        //name에 A가 있다면 커서를 굳이 오른쪽으로 이동해 +1씩안하고 왼쪽으로 이동해서 계산하는 경우도 있음
        //ex) JAJ라면 0번째 j에서 커서를 맨뒤로 한번만 이동해서 j로 바꾸면 굳이 중간 a를 안지나도 됨

        //알파벳 이동 카운트
        for(int i=0; i<name.length(); i++){
            char current = name.charAt(i);

            int up = current - 'A';
            int down = 'Z' - current + 1;

            answer += Math.min(up, down);
        }

        //커서 이동 카운트
        int move = name.length() - 1;//오른쪽으로 이동했을 때의 커서 이동 수
        // int aCnt = 0;
        for (int i = 0; i < name.length(); i++) {
            int next = i + 1; //index

            while (next < name.length() && name.charAt(next) == 'A') {
                next++;
            }

            // 오른쪽으로 갔다가 되돌아오는 경우
            int rightThenBack = i * 2 + name.length() - next;

            // 반대 방향으로 갔다가 돌아오는 경우
            int leftThenBack = (name.length() - next) * 2 + i;

            move = Math.min(move, rightThenBack);
            move = Math.min(move, leftThenBack);
        }
        answer += move;
        return answer;
    }
}