import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int A,B;
        int cnt = 0;

        for (A = 1; A <= 500; A++) {
            for (B = 1; B <= 500; B++) {
                if ((A * A) == (B * B) + n) {
                    cnt ++;
                }
            }
        }
        System.out.println(cnt);

    }
}
