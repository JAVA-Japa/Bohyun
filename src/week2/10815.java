import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int result = BinarySearch(Integer.parseInt(st.nextToken()));
            if(result == -1){
                System.out.print("0 ");
            }else{
                System.out.print("1 ");
            }

        }


    }

    private static int BinarySearch(int input) {

        int l = 0;
        int r = arr.length-1;
        int m;

        while (l <= r) {
            m = (l + r) / 2;
            if(arr[m] < input){
                l = m+1;
            } else if (arr[m] > input) {
                r = m -1;
            }else{
                return m;
            }
        }
        return -1;
    }
}
