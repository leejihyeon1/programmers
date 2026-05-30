package Hash;

import java.util.*;

//해시 - 베스트앨범
//스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다.
//노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.
//노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때,
//베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
public class bestAlbum {
    //1. 문제를 단순하게 하기!
    public int[] solution(String[] genres, int[] plays) {
        //장르 별 재생횟수 더한거
        HashMap<String,Integer> genreTotalMap = new HashMap<>();
        //장르마다 재생횟수
        //key : 장르, value : [고유번호(index),재생횟수]
        HashMap<String, List<int[]>> songMap = new HashMap<>();


        //2. 데이터 저장
        for(int i=0; i<genres.length; i++){
            String genre = genres[i];
            int play = plays[i];

            //3. 장르 총 재생 횟수 누적(마지막 업데이트 값으로 덮어쓰기 되니까 기존 값에 더해줘야함)
            genreTotalMap.put(genre, genreTotalMap.getOrDefault(genre,0)+play);

            //4. 장르 별 리스트 생성
            songMap.putIfAbsent(genre,new ArrayList<>());
            songMap.get(genre).add(new int[]{i,play});
        }

        //5.장르를 총 재생 횟수 기준 내림차순 정렬
        List<String> genreOrder = new ArrayList<>(genreTotalMap.keySet());
        genreOrder.sort((a, b) -> genreTotalMap.get(b)-genreTotalMap.get(a));

        //6.결과 저장
        List<Integer> result = new ArrayList<>();
        
        //7.장르별 노래 정렬
        for(String genre : genreOrder){
            List<int[]> songs = songMap.get(genre);
            //8.재생 횟수 내림차순
            //같으면 고유번호 오름차순
            songs.sort((a, b) ->{

                if(a[1] == b[1]){//재생 횟수 같으면
                    return a[0]-b[0]; //고유번호 오름차순 (a[0]은 고유번호, a[1]은 재생횟수)
                }
                return b[1]-a[1];//a[1]-b[1]이면 오름차순, b[1]-a[1]은 내림차순
            } );

            //9.장르 당 2개씩 고유번호 저장
            for(int i=0; i< songs.size() && i<2; i++){
                result.add(songs.get(i)[0]);
            }
        }

        //10.결과 출력
        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}