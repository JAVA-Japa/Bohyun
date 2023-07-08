import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        int result = 0;



        for (int b = 1; b <= n; b++) {
            for (int c = 1; c <= n; c++) {
                if(2+b <= c) {
                    for (int a = 1; a <= n; a++) {
                        if (a % 2 == 0 && a + b + c == n) {
                            result++;
                        }
                    }
                }
            }
        }

        System.out.println(result);

    }
}
