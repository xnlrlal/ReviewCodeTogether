import java.util.Arrays;

/*
    << 연속된 수의 합 >>
    문제 설명
        연속된 세 개의 정수를 더해 12가 되는 경우는 3, 4, 5입니다.
        두 정수 num과 total이 주어집니다.
        연속된 수 num개를 더한 값이 total이 될 때,
        정수 배열을 오름차순으로 담아 return하도록 solution함수를 완성해보세요.

    제한사항
        - 1 ≤ num ≤ 100
        - 0 ≤ total ≤ 1000
        - num개의 연속된 수를 더하여 total이 될 수 없는 테스트 케이스는 없습니다.
 */
public class TheSumOfConsecutiveNumbers {
    public int[] solution(int num, int total) {
        // num만큼 배열의 크기 할당.
        int[] answer = new int[num];
        // 배열 중 가장 처음에 올 숫자
        int initial;
        if (num % 2 == 0) { // 짝수일 경우
            // total/num을 올림한 값을 중앙값이라고 보는데
            // num이 짝수일 경우 두개의 중앙값중 큰 수를 구함.
            // 큰 수를 num/2로 빼주면 가장 첫번째 값을 구할 수 있음.
            // total/num을 올림한 값에서 num/2로 나눈 몫을 빼줌.
            initial = (int) (Math.ceil((double) total / num)) - (num / 2);
        } else { // 홀수일 경우
            // 중앙값을 구하고 num/2의 몫만큼 빼면 첫번째 값을 구할 수 있음.
            initial = (total / num) - (num / 2);
        }
        // num만큼 반복
        for (int i = 0; i < num; i++) {
            // 첫번째 값부터 차례대로 1을 더해준 값을 배열에 추가.
            answer[i] = initial;
            initial++;
        }
        return answer;
    }

    public static void main(String[] args) {
        TheSumOfConsecutiveNumbers numbers = new TheSumOfConsecutiveNumbers();
        int[] result;
        result = numbers.solution(3, 12);
        System.out.println(Arrays.toString(result)); // [3, 4, 5]
        result = numbers.solution(5, 15);
        System.out.println(Arrays.toString(result)); // [1, 2, 3, 4, 5]
        result = numbers.solution(4, 14);
        System.out.println(Arrays.toString(result)); // [2, 3, 4, 5]
        result = numbers.solution(5, 5);
        System.out.println(Arrays.toString(result)); // [-1, 0, 1, 2, 3]
    }
}
