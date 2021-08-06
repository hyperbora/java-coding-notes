package io.github.hyperbora.search;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Bfs {
    public static int[] bfs(int[][] graph, int start) {
        boolean[] visited = new boolean[graph.length];
        Deque<Integer> q = new ArrayDeque<>();
        List<Integer> resultList = new ArrayList<>();

        q.add(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            var v = q.pollFirst();
            resultList.add(v);
            for (var i : graph[v]) {
                if (!visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[][] graph = { {}, { 2, 3, 8 }, { 1, 7 }, { 1, 4, 5 }, { 3, 5 }, { 3, 4 }, { 7 }, { 2, 6, 8 }, { 1, 7 }, };
        var result = bfs(graph, 1);
        Arrays.stream(result).forEach(System.out::println);
    }
}
