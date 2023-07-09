import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int countStrike;
    static int countBall;
    static int turn; // 질문의 차례(몇번째 질문인가)를 세기위한 변수
    static String[] numbers = new String[3]; // 입력받은 세자리 수 각 자리를 저장할 배열
    static ArrayList<Integer> list = new ArrayList(987);
    // 기준에 맞는 숫자를 저장할 ArrayList. 최대 987개의 수가 들어가므로 크기를 지정해줌.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {

            String[] input = br.readLine().split(" ");

            numbers[0] = input[0].charAt(0) + "";
            numbers[1] = input[0].charAt(1) + "";
            numbers[2] = input[0].charAt(2) + "";

            countStrike = Integer.parseInt(input[1]);
            countBall = Integer.parseInt(input[2]);

            turn++; //몇 번째 질문인지 세는 변수

            cal(numbers);
        }

        // 반복문이 종료되고 list의 최종 size를 출력한다.
        System.out.println(list.size());

    } // and of main

    // 계산이 수행되는 cal메서드
    static void cal(String[] numbers) {

        // 조건에 맞는 숫자를 넣을 tmp list를 선언.
        ArrayList<Integer> tmp = new ArrayList();

        // 123부터 987까지 반복문을 돌며 비교대상 숫자(입력된 숫자)와 strike,ball수가 일치하는지 확인한다.
        // 반복문의 역할은 123부터 987의 숫자와 입력된 숫자를 비교하고 strike갯수와 ball의 갯수를 세는 역할임.
        for (int k = 123; k <= 987; k++) {

            int strike = 0;
            int ball = 0;

            int first = k / 100;
            int second = ((k%100)/10);
            int third = ((k%100)%10);

            // 세 자리에 같은 숫자가 있거나 0이 나오면 비교하지 않고 다음 숫자로
            if (first == 0 || second == 0 || third == 0 || first == second || first == third || third == second)
                continue;

            int[] arr = { first, second, third };

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {

                    if (arr[i] == Integer.parseInt(numbers[j])) {

                        if (i == j) {
                            strike++;
                            continue;
                        }
                        ball++;
                    }
                }
            }


            if (countStrike == strike && countBall == ball) {
                tmp.add(k);
            }
        }


        if (turn != 1)
            list.retainAll(tmp); //turn이 2 이상인 경우는 교집합만 넣기
        else
            list.addAll(tmp);
    }

}
