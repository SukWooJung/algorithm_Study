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

			// ���� ����
			int N = Integer.parseInt(br.readLine());

			int[] score = new int[N]; // ���� �������� ���� �迭
			int sum = 0;

			// ������ ����
			String[] str = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				score[i] = Integer.parseInt(str[i]);
				sum += score[i];
			}

			int[] AllScore = new int[sum + 1]; // ������ �������� ����
			AllScore[0]++;

			// ����
			// Arrays.sort(score);

			// �˻�
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = AllScore.length - 1; j >= 0; j--) {
					if (AllScore[j] == 1) {
						AllScore[j + score[i]] = 1;
					}
				}
			}

			// ���� ����
			for (int j = 0; j < AllScore.length; j++) {
				if (AllScore[j] > 0) {
					count++;
				}
			}

			bw.write("#" + test_case + " " + count + "\n");
		}
		bw.flush();
		br.close();
		bw.close();

	}
}
