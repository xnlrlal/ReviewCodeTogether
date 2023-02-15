import java.util.Arrays;

/*
    -- 분수의 덧셈 --
    문제 설명
        첫 번째 분수의 분자와 분모를 뜻하는 numer1, denom1,
        두 번째 분수의 분자와 분모를 뜻하는 numer2, denom2가 매개변수로 주어집니다.
        두 분수를 더한 값을 기약 분수로 나타냈을 때
        분자와 분모를 순서대로 담은 배열을 return 하도록 solution 함수를 완성해보세요.

    제한사항
        - 0 <numer1, denom1, numer2, denom2 < 1,000
 */
public class AdditionOfFractions {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        // Math함수를 이용해 분모가 더 큰 것과 작은 것을 나눔
        int demax = Math.max(denom1, denom2);
        int demin = Math.min(denom1, denom2);
        int numer, denom; // 통분한 분자, 분모

        if(denom1 != denom2) { // 분모가 다를 경우
            if (demax % demin == 0) { // 분모끼리 나눌 수 있을 경우
                int a = (demax / demin); // 분모의 비
                // 삼항 연산자를 활용해 각자의 분자를 확인하고 작은 분모의 분자에 a를 곱해주어 더함.
                numer = (demin == denom1 ? numer1 : numer2) * a + (demax == denom2 ? numer2 : numer1);
                denom = demax; // 분모가 큰 것이 최종 분모가 됨.
            } else { // 분모끼리 나누어지지 않을 경우
                // 일단 분모를 곱하여 분모를 같게 해주고 분자에 다른 분모를 곱해주어 통분함.
                numer = (numer1 * denom2) + (numer2 * denom1);
                denom = denom1 * denom2;
            }
        } else { // 분모가 같을 경우
            numer = numer1 + numer2; // 분자를 더해 통분함.
            denom = demax;
        }

        int cnt = 2; // while문에서 약분하기 위해 반복될 수
        while(true) { // 약분을 위한 반복문
            // cnt로 나누어진다면 나누어지지 않을 때까지 반복
            if (numer % cnt == 0 && denom % cnt == 0) {
                numer = numer / cnt;
                denom = denom / cnt;
            // 더 이상 약분되지 않는다면 break
            } else if (cnt > 1000 || cnt > numer || cnt > denom) {
                break;
            } else cnt++; // 나누어 지지 않는다면 cnt에 1을 더해줌.
        }

        // 최종적으로 구해진 분자, 분모를 배열에 추가
        answer[0] = numer;
        answer[1] = denom;

        System.out.println(Arrays.toString(answer));

        return answer;
    }

    public static void main(String[] args) {
        AdditionOfFractions fractions = new AdditionOfFractions();
        int[] result = fractions.solution(1,2,3,4);
        System.out.println(result);
        result = fractions.solution(9,2,1,3);
        System.out.println(result);
        result = fractions.solution(1,3,1,3);
        System.out.println(result);
        result = fractions.solution(273,678,78,1000);
        System.out.println(result);
    }
}
