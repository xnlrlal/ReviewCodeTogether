/*
    << H-Index >>
    문제 설명
        H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다.
        어느 과학자의 H-Index를 나타내는 값인 h를 구하려고 합니다.
        위키백과1에 따르면, H-Index는 다음과 같이 구합니다.

        어떤 과학자가 발표한 논문 n편 중,
        h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면
        h의 최댓값이 이 과학자의 H-Index입니다.

        어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때,
        이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.

    제한사항
        - 과학자가 발표한 논문의 수는 1편 이상 1,000편 이하입니다.
        - 논문별 인용 횟수는 0회 이상 10,000회 이하입니다.
 */

import java.util.Arrays;

public class HIndex {
    public int solution(int[] citations) {
        int answer = citations.length;
        // 오름차순으로 정렬해서 혹시라도 순서가 뒤집혀 다른 답이 나올 것을 배제함.
        Arrays.sort(citations);

        // 향상된 for문 : citations 각각의 값을 citation으로 정의
        for (int citation : citations) {
            // h의 최대값은 결국 배열의 길이가 될 것임.
            // citation이 배열의 길이보다 작다면 1이 줄어듦.
            if (citation < answer) answer--;
        }

        return answer;
    }

    public static void main(String[] args) {
        HIndex hIndex = new HIndex();
        int result;
        result = hIndex.solution(new int[]{3, 0, 6, 1, 5});
        System.out.println(result); // 3
        result = hIndex.solution(new int[]{3, 4, 5, 11, 15, 16, 17, 18, 19, 20});
        System.out.println(result); // 7
    }
}
