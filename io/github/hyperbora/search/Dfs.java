package io.github.hyperbora.search;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class Dfs {
    public static int[] dfs(int[][] graph, int start) {
        boolean[] visited = new boolean[graph.length];
        Deque<Integer> stack = new ArrayDeque<>();
        List<Integer> resultList = new ArrayList<>();

        stack.addLast(start);
        while (!stack.isEmpty()) {
            var cur = stack.pollLast();
            if (!visited[cur]) {
                visited[cur] = true;
                resultList.add(cur);
                var childrens = Arrays.stream(graph[cur]).filter(i -> !visited[i]).boxed().collect(Collectors.toList());
                Collections.reverse(childrens);
                stack.addAll(childrens);
            }
        }
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[][] graph = { {}, { 2, 3, 8 }, { 1, 7 }, { 1, 4, 5 }, { 3, 5 }, { 3, 4 }, { 7 }, { 2, 6, 8 }, { 1, 7 }, };
        var result = dfs(graph, 1);
        Arrays.stream(result).forEach(System.out::println);
    }
}
