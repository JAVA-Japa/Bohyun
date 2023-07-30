import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static char[] arr = new char[10]; //부등호 최대 9개
    private static boolean[] visited = new boolean[10]; //숫자 0~9
    private static List<String> ans = new ArrayList<>();

    static boolean ck(char a, char b, char c) {
        if (c == '<') {
            if (a > b) {
                return false;
            }
        }
        if (c == '>') {
            if (a < b) {
                return false;
            }
        }
        return true;

    }

    static void go(int index, String num) {
        if (index == N + 1) {
            ans.add(num);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if(visited[i])
                continue;
            if(index == 0 || ck(num.charAt(index-1), (char) (i + '0'), arr[index-1] )) {
                visited[i] = true;
                go(index + 1, num + Integer.toString(i));
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());


        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        go(0, "");
        Collections.sort(ans);

        System.out.println(ans.get(ans.size() - 1));
        System.out.println(ans.get(0));





    }

}
