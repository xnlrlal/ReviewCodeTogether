/*
    << 둘만의 암호 >>
    문제 설명
        두 문자열 s와 skip, 그리고 자연수 index가 주어질 때, 다음 규칙에 따라 문자열을 만들려 합니다.
        암호의 규칙은 다음과 같습니다.

        문자열 s의 각 알파벳을 index만큼 뒤의 알파벳으로 바꿔줍니다.
        index만큼의 뒤의 알파벳이 z를 넘어갈 경우 다시 a로 돌아갑니다.
        skip에 있는 알파벳은 제외하고 건너뜁니다.
        예를 들어 s = "aukks", skip = "wbqd", index = 5일 때,
        a에서 5만큼 뒤에 있는 알파벳은 f지만 [b, c, d, e, f]에서 'b'와 'd'는 skip에 포함되므로 세지 않습니다.
        따라서 'b', 'd'를 제외하고 'a'에서 5만큼 뒤에 있는 알파벳은 [c, e, f, g, h] 순서에 의해 'h'가 됩니다.
        나머지 "ukks" 또한 위 규칙대로 바꾸면 "appy"가 되며 결과는 "happy"가 됩니다.

        두 문자열 s와 skip, 그리고 자연수 index가 매개변수로 주어질 때
        위 규칙대로 s를 변환한 결과를 return하도록 solution 함수를 완성해주세요.

    제한사항
        - 5 ≤ s의 길이 ≤ 50
        - 1 ≤ skip의 길이 ≤ 10
        - s와 skip은 알파벳 소문자로만 이루어져 있습니다.
            ㄴ skip에 포함되는 알파벳은 s에 포함되지 않습니다.
        - 1 ≤ index ≤ 20
 */
public class OurOwnCode {
    public String solution(String s, String skip, int index) {
        String answer = "";

        // s문자열을 비교하기 위해서 s의 길이만큼 반복.
        for (int i = 0; i < s.length(); i++) {
            // iletter라는 변수에 s문자열을 문자 단위로 쪼개어 int형으로 저장.
            int iletter = s.charAt(i);
            // index만큼 반복을 위한 변수.
            int x = 0;

            // index 횟수만큼 반복
            while (x < index) {
                // s문자열과 skip문자열은 같을 수 없기 때문에 우선적으로 다음 알파벳으로 1만큼 이동.
                iletter++;
                // 더했을 경우 122를 넘어가면 알파벳이 아니므로 바로 a(97)로 돌아옴.
                if (iletter > 122) { iletter  = 97; }
                // 겹치는 문자가 있을 경우 겹치는 만큼 반복 .
                while (skip.contains(String.valueOf((char) iletter))) {
                    // 다음 문자로 이동
                    iletter++;
                    // 122가 넘어가면 a로 돌아옴.
                    if (iletter > 122) { iletter  = 97; }
                }
                // index와 같아질 때 까지 1만큼씩 증가.
                x++;
            }
            // 마지막에 int형으로 변환된 문자를 다시 char형으로 변환하여 answer에 추가.
            answer += (char) iletter;
        }
        return answer;
    }

    public static void main(String[] args) {
        OurOwnCode code = new OurOwnCode();
        String result;
        result = code.solution("aukks", "wbqd", 5);
        System.out.println(result); // happy
        result = code.solution("z", "abcdefghij", 20);
        System.out.println(result); // n
        result = code.solution("ybcde", "az", 1);
        System.out.println(result); // bcdef
    }
}
