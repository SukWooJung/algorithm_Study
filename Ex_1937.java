package ����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex_1937 {
	private static int[][] map;
	private static int[] dr = { -1, 1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };
	private static int[][] dp;

	// ������� �Ǵ� (���3) dp, dfs
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		// �� �����
		map = new int[N][N];
		dp = new int[N][N];
		for (int row = 0; row < map.length; row++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int col = 0; col < map[0].length; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}

		// max�� �ϳ��� ���� �� �ִ� ���� ã�� ��
		int max = 1;
		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map[0].length; col++) {
				int temp = dfs(row, col);
				max = max < temp ? temp : max;
			}
		}
		System.out.println(max);
	}

	private static int dfs(int row, int col) {
		if (dp[row][col] != 0) { // dp�� visited�� ���ҵ� �ϰ�, ���ŵǸ� ���� ����� �ִ� �湮���� ����� ���� ����Ǿ� ����
			return dp[row][col]; // ���� �ڸ��� dp�� 0�� �ƴϸ�, dp�� ��ȯ 
		}
		dp[row][col] = 1;

		int num = map[row][col];
		int maxNV = 0; // �湮���� ���� ��ǥ�� ���� ���� �ִ�
		int maxV = 0; // �湮�� ������ ���� ���� �ִ�
		for (int i = 0; i < dc.length; i++) {
			int tr = row + dr[i];
			int tc = col + dc[i];

			if (tr >= 0 && tc >= 0 && tr < map.length && tc < map[0].length && map[tr][tc] > num) { // �����¿� �� ū ���� ������ ã�ư���. 
				int visitedCnt = dp[tr][tc];
				if (visitedCnt != 0 && visitedCnt > maxV) { // visitedCnt != 0�̸� �湮������ �ִٴ� ��. 
					maxV = visitedCnt; // �湮�� ���� �� �ִ��� ã�� maxV�� ����
				} else {
					int NVisitedCnt = dfs(tr, tc); // �湮���� �ʾ����� ���(dfs)
					if(NVisitedCnt > maxNV) { 
						maxNV = NVisitedCnt; // �湮���� �ʾҴ� ���� �� �ִ��� ã�� maxNV�� ����
					}
					
				}
			}
		}
		
		if(maxV >= maxNV) { // �湮�� ���� �ִ�, �湮���� ���� ���� �ִ��� ���� ���ؼ� ū���� +1�ؼ� ��ȯ. 1�� �ڱ��ڽ��� ����.
			dp[row][col] = 1+ maxV;
			return 1 + maxV;
		}else {
			dp[row][col] = 1 + maxNV;
			return 1 + maxNV;
		}		
	}
}
