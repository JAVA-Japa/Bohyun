import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        }); //시작 시간 기준으로 정렬

        PriorityQueue<Integer> pq = new PriorityQueue<>(); //끝나는 시간 오름차순 정렬
        pq.offer(arr[0][1]);

        for (int i = 1; i < N; i++) {
            if (pq.peek() <= arr[i][0]) {
                pq.poll();
            }
            pq.offer(arr[i][1]);
        }

        System.out.print(pq.size());
    }
}
