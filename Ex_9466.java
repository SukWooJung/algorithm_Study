package ����;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex_9466 {
	// �� ������Ʈ(���4)
	private static boolean[] visited;
	private static boolean[] finished;
	private static Queue<Integer> queue = new LinkedList<Integer>();
	private static int answer = 0;
	private static int[] adj;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());

			// ���� ����Ʈ
			adj = new int[N + 1];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for (int node = 1; node < N + 1; node++) {
				adj[node] = Integer.parseInt(st.nextToken());
			}

			visited = new boolean[N + 1];
			finished = new boolean[N + 1];

			for (int node = 1; node < N + 1; node++) {
				dfs(node, 1);
			}
			// ���� ���
			bw.write(N - answer + "\n");

			answer = 0;
		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static void dfs(int node, int depth) {
		// �湮 �˻�
		if (visited[node] || finished[node]) {
			queue.clear();
			return;
		}
		
		// �湮 ó��
		visited[node] = true;

		// �ڱ� �ڽŰ� cycle�� ��� �˻�
		if (adj[node] == node) {
			finished[node] = true;
			answer++;
			queue.clear();
			return;
		}
		
		// �迭�� ����ִ� ������ Ȯ���ϸ鼭, ����Ŭ Ȯ��
		if (!queue.isEmpty() && queue.contains(adj[node])) {
			int temp = queue.poll();
			while (temp != adj[node]) {
				depth--;
				temp = queue.poll();
			}
			answer += depth;
			queue.clear();
			return;
		}
		queue.offer(node);
		dfs(adj[node], depth + 1);
		
		finished[node] = true;
	}
}
