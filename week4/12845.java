import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer[]init = new Integer[n];

        for (int i = 0; i < n; i++) {
            init[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(init, Collections.reverseOrder()); //내림차순 정렬

        int maxLevel = init[0];
        int[] gold = new int[n - 1];
        gold[0] = init[0] + init[1];
        int sum = gold[0];


        for (int i = 1; i < n - 1; i++) {
            gold[i] = init[i + 1] + maxLevel;
            sum += gold[i];
        }

        System.out.println(sum);

    }
}
