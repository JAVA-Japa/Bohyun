import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int s, g = 0; //s = sheep, g = goat
        int cnt = 0;
        int sheep = 0; 
        int goat = 0;

        for (s = 1; s < n; s++) {
            for (g = 1; g < n; g++) {
                if(s + g == n && (a*s) + (b*g) == w){
                    cnt++;
                    sheep = s;
                    goat = g;
                }
            }
        }

       if( cnt == 1){
           System.out.println(sheep + " " + goat);
       }
       else{
           System.out.println("-1");
       }

    }
}
