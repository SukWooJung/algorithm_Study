package SWE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex_3752_1 {
	// 3752. ������ �������� (d4)
	// ù��° Ǯ��. �迭
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine()); // test_case ����

		for (int test_case = 1; test_case <= T; test_case++) {

			// �迭
			int[] arr = new int[101]; // ���� �������� ���� �迭
			int[] temp = new int[10000]; // ������ �������� ����
			
			// ������ ����
			String[] str = br.readLine().split(" ");
			for (int i = 0; i < str.length; i++) {
				arr[i] = Integer.parseInt(str[i]);
				temp[i] = Integer.parseInt(str[i]);
			}
			
			// ����
			Arrays.sort(arr);
			Arrays.sort(temp);
			
			// �˻�
			int cnt = str.length + 1; // 1�� 0�� ������ ���Ѱ� 
			for (int i = 0; i < arr.length - 1; i++) {
				for (int j = i + 1; j < str.length; j++) {
					
				}
			}

		}

	}
}
