package io.github.hyperbora.math;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Combination {
    public static <T> void comb(T[] arr, boolean[] visited, int start, int r, List<List<T>> combinationList) {
        if (r == 0) {
            combinationList.add(IntStream.range(0, visited.length).filter(i -> visited[i]).mapToObj(i -> arr[i])
                    .collect(Collectors.toList()));
        } else {
            for (int i = start; i < arr.length; i++) {
                visited[i] = true;
                comb(arr, visited, i + 1, r - 1, combinationList);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> combinationList = new ArrayList<>();
        Integer[] arr = { 1, 2, 3, 4 };
        boolean[] visited = new boolean[arr.length];

        // example : nCr -> 4C3
        comb(arr, visited, 0, 3, combinationList);

        for (var lst : combinationList) {
            System.out.print("[");
            for (var item : lst) {
                System.out.print(item + " ");
            }
            System.out.println("\b]");
        }
    }
}