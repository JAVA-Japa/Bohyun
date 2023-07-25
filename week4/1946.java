import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][2];	// 각 지원자의 서류, 면접 성적

            for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }


            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] arr1, int[] arr2) {	// 서류를 기준으로 오름차순 정렬
                    return Integer.compare(arr1[0], arr2[0]);
                }
            });

            int count = 1;
            int pivot = arr[0][1];
            for(int i=1; i<N; i++) {
                if(arr[i][1] < pivot) {
                    count ++;
                    pivot = arr[i][1];
                }
            }
            System.out.println(count);
        }
    }
}
