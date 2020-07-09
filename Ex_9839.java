package SWE;
import java.io.*;

public class Ex_9839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // ?��?��?�� �??��?�� 개수
        for (int Test_Case = 1; Test_Case <= T; Test_Case++) {

            int n = Integer.parseInt(br.readLine()); // �??��?�� ?�� ?��?��?�� 개수 n
            String str[] = br.readLine().split(" ");
            int arr[] = new int[str.length];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            // �??�� ?��?��
            int MaxResult = -1;
            for (int i = 0; i < arr.length - 1; i++) {
                int x = arr[i];
                for (int j = i + 1; j < arr.length; j++) {
                    int y = arr[j];
                    int z = x * y; // z?�� �? ?��개의 �?
                    int num = z % 10;
                    z /= 10;

                    // 구체?��?�� �??��
                    boolean check = true; // check?? 10진수?��?�� ?��?��?�� ?��?��?���? �??��
                    while (z > 0) { // z�? 1?�� ?��리수 ???���? ?��?�� ?���??�� ?��?��. ?��?��?��, 1?�� ?���? ?�� ?�� ?�� check?�� true,
                                    // MaxResult < x*y?�� 만족
                        if (num - 1 == z % 10) {
                            num--;
                            z /= 10;
                        } else {
                            check = false;
                            break;
                        }
                    }
                    if (check && MaxResult < x * y) { // �??��(10진수 ?��?��)�? 만족?���? ?�� ?���? 갱신
                        MaxResult = x * y; // z?�� ?���? /10�? 계속 쪼개졌음
                    }
                }
            }
            bw.write("#" + Test_Case + " " + MaxResult + "\n");
        }
        bw.close();
        br.close();
    }
}
