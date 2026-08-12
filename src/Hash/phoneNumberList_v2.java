package Hash;

import java.util.Arrays;
import java.util.HashMap;

//해시 - 전화번호 목록
//전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
//전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때,
//어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
public class phoneNumberList_v2 {
    //1. 문제를 간단하게 생각하기
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);//자리별 오름차순 정렬
        for(int i=0; i<phone_book.length-1; i++){
            if(phone_book[i+1].startsWith(phone_book[i])){
                return false;
            }
        }
        return true;
    }
}