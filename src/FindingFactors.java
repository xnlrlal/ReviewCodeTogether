import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.IntFunction;

/*
    << 약수 구하기 >>
    문제 설명
        정수 n이 매개변수로 주어질 때,
        n의 약수를 오름차순으로 담은 배열을 return하도록 solution 함수를 완성해주세요.

    제한사항
        - 1 ≤ n ≤ 10,000
 */
public class FindingFactors {
    public int[] solution(int n) {
        ArrayList<Integer> answerList = new ArrayList<Integer>();

        for (int i = 1; i <= n/2; i++) {
            if (n % i == 0) {
               answerList.add(i);
            }
        }
        answerList.add(n);

        int[] answer = answerList.stream()
                .mapToInt(i -> i)
                .toArray();

        return answer;
    }

    public static void main(String[] args) {
        FindingFactors factors = new FindingFactors();
        int[] result;
        result= factors.solution(24);
        System.out.println(Arrays.toString(result)); // [1, 2, 3, 4, 6, 8, 12, 24]
        result= factors.solution(29);
        System.out.println(Arrays.toString(result)); // [1, 29]
    }
}
